package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@GetMapping("non_ajax")
	public String nonAjax() {
		return "non_ajax";
	}
	
	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax 연결");
		return "ajax";
	}
	
	static int cnt=0;
	@GetMapping("ajax_result")
	@ResponseBody
	public String ajax_result() {
		return ++cnt + "";
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax_01";
	}
	@PostMapping(value="ajax_result01", 
			produces = "application/json; charset=utf-8")
	@ResponseBody //json형태를 받아올 때 사용한다 + 페이지 요청이 아니라 Data type을 받아오고 돌려주기 위해 씀
	public InfoDTO ajax_result01(@RequestBody InfoDTO dto) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		dto.setName("변경된 이름");
		dto.setAge("200살");
		return dto;
	}
	@PostMapping(value="ajax_result02", 
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map ajax_result02(@RequestBody Map dto) {
		System.out.println(dto.get("name"));
		System.out.println(dto.get("age"));
		System.out.println(dto.get("addr"));
		return dto;
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}
	
	@GetMapping("getuser")
	public String getUser() {
		return "getuser";
	}
}











