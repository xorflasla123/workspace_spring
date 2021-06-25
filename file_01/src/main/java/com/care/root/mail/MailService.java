package com.care.root.mail;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper me = new MimeMessageHelper(message,true,"utf-8");
			me.setSubject(subject); //제목
			me.setTo(to); //보내는 곳
			me.setText(body, true); //내용 true 적지 않으면 그냥 text로 넘어간다
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void auth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = "ltlking";
		String userKey = rand();
		session.setAttribute(userId, userKey);
		String body="<h2>안뇽하세요</h2>"
				+ "<a href='http://localhost:8087/root/auth_check?"
				+ "userid="+userId+"&userkey="+userKey+"'>인증하기</a>";
		sendMail("xorflasla123@daum.net", "인증(제목)", body);
	}
	public String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length()!=20) {
			num = ran.nextInt(75)+48; //num=48~122 ASCII 숫자, 대문자, 소문자
			if((num>=48 && num<=57) || (num>=65 && num<=90) || (num>=97 && num<=122)) {
				//순서대로 숫자, 대문자, 소문자 순
				str += (char)num;
			}
		}
		return str;
	}
}
