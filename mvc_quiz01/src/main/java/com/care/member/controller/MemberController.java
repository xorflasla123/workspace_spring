package com.care.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/memberShip")
	public String memberShip(Model model) {
		ms.getMembers(model);
		return "memberShip";
	}
	
	@GetMapping("/memberForm")
	public String memberForm() {
		return "memberForm";
	}
	
	@PostMapping("/register") //이러한 주소가 호출될 때 실행된다
	public String register(MemberDTO dto) {
		ms.register(dto);
		return "index"; //view폴더에 있는 jsp파일을 호출
	}
}
