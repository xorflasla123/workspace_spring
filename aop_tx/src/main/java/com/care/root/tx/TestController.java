package com.care.root.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired TestServiceImpl ts;
	
	@GetMapping("chart")
	public String chart() {
		return "testchart";
	}
	
	@GetMapping("buy_form")
	public String buy_form() {
		System.out.println("==== buy_form 시작 ====");
		return "buy_form";
	}
	@PostMapping("buy")
	public String buy(Model model,
						@RequestParam(value = "num", required = false, defaultValue = "0") int num) {
		ts.buy(model, num);
		return "result";
	}
	@GetMapping("db_result")
	public String dbResult(Model model) {
		ts.dbResult(model);
		return "db_result";
	}
}
