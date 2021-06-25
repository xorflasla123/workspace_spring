package com.care.di_ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mm")
public class MemberController { // memberController
	MemberService ms;
	
//	public MemberController() {
//		System.out.println("memberController 실행");
//	}
	
	@RequestMapping("insert")
	public String insert(Model model) {
		model.addAttribute("test", "연습중");
		ms = new MemberService();
		ms.insert(model);
		return "di/index";
	}
}
