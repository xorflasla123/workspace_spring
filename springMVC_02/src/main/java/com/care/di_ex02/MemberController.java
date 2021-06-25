package com.care.di_ex02;

//import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	//@Inject // 같은 기능
	@Autowired // new대신에 이런식으로 해당하는 bean을 자동 대입한다.
	@Qualifier("ser")
	MemberService ms;
	
	@RequestMapping("insert")
	public String insert(Model model) {
		System.out.println(ms);
		try {
			ms.insert(model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "di/index";
	}
}
