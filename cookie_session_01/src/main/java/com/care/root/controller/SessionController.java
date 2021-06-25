package com.care.root.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
	@GetMapping("makeSession")
	public String makeSession(HttpServletRequest request) {
		HttpSession session = request.getSession(); //세션 사용하는 방법 1
		session.setAttribute("id", "a123");
		session.setAttribute("name", "홍길동");
		session.setAttribute("addr", "산골짜기");
		return "session/makeSession";
	}
	
	@GetMapping("resultSession")
	public String resultSession() {
		return "session/resultSession";
	}
	
	@GetMapping("delSession")
	public String delSession(HttpSession session) { //세션 사용하는 방법 2
		session.invalidate(); //세션 만료시키기
		return "session/delSession";
	}
}
