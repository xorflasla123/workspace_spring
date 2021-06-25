package com.care.di_ex01;

import org.springframework.ui.Model;

public class MemberService {
	MemberDAO dao;
	public void insert(Model model) {
		dao = new MemberDAO();
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
