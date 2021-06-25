package com.care.mvc_ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="/index") //url경로
	public String memberIndex() {
		return "/member/index"; //jsp파일 경로
	}
	@RequestMapping("/logout")
	public String memberLogout(Model model) {
		//데이터베이스 연동 후 결과값을 jsp로 전달하고자 한다.
		String id = "db에서 가져온 아이디";
		model.addAttribute("userId", id);
		return "member/logout";
	}
	@RequestMapping("login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "로그인성공");
		mv.setViewName("member/login");
		return mv; 
	}
}
