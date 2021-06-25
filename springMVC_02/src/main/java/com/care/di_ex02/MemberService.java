package com.care.di_ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("ms1")
public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("Service생성자 실행");
	}
	
	public void insert(Model model) {
		//dao = new MemberDAO();
		int result = dao.insert();
		String msg;
		if(result == 0) {
			msg = "저장이 되었습니다";
		}else {
			msg = "실패 하였습니다";
		}
		model.addAttribute("test", msg);
	}
}
