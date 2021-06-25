package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("re/index") //웹페이지 url경로
	public String index() {
		return "re/index"; // jsp 파일의 경로
	}
	
	@RequestMapping("re/result")
	public String result(HttpServletRequest req, Model model,
							RedirectAttributes ra) {
		String id = req.getParameter("id");
		System.out.println(id);
		logger.info("-----"+id+"-----");
		if(id.equals("abc")) {
			//model.addAttribute("success", "로그인 성공!!");
			ra.addFlashAttribute("success", "redirectAttributes를 통한 전달");
			TestDTO dto = new TestDTO();
			dto.setId("dto를 통한 아이디 저장");
			ra.addFlashAttribute("dto", dto);
			return "redirect:rsOK"; 
			// model값은 request값처럼 한번만 이동이라 redirect로 밑에서 또 부르는순간 값이 사라진다.
			// 그래서 로그인 성공이라는 값이 뜨지 않는다.
		}
		return "redirect:rsNO"; //이게 밑에로 연결된다(조건에 따라 재요청하기 때문에 다시 컨트롤러에서 처리하는듯
	}
	
	@RequestMapping("re/rsOK")
	public String rsOK() {
		return "re/rsOK";
	}
	
	@RequestMapping("re/rsNO")
	public String rsNO() {
		return "re/rsNO";
	}
	
}
