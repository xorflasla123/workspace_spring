package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		return "get_post/index";
	}
	
	@RequestMapping("/result") // 명시하지 않으면 get, post 알아서 맞게 써짐
	public String result(Model model, HttpServletRequest req) {
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", req.getParameter("name")+"님");
		model.addAttribute("age", req.getParameter("age")+"살");
		return "get_post/result";
	}
	
	//@GetMapping // 한 방식만 사용할 때 그냥 이렇게 쓰면 됨
	@GetMapping("/result")
	public String result(Model model, HttpServletRequest req, 
								@RequestParam String name, 
								@RequestParam("age") String a) {
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", name + "님");
		model.addAttribute("age", a + "살");
		return "get_post/result";
	}
	
	//@PostMapping
	@PostMapping("obj_result")
	public String obj_result(Model model, MemberDTO dto) {
		model.addAttribute("dto", dto);
		return "get_post/result";
	}
}
















