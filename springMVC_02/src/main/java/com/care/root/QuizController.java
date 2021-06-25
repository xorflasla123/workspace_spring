package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuizController {
	@Autowired
	QuizService qs;
	@RequestMapping("index")
	public String index() {
		return "quiz/index";
	}
	
	@PostMapping("check")
	public String check(@RequestParam String id, @RequestParam String pwd,
							RedirectAttributes re) {
		re.addFlashAttribute("dto", qs.check(id, pwd));
		return "redirect:index";
	}
}
