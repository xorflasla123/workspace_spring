package com.care.root.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("cookie")
	public String myCookie(HttpServletResponse response,
							@CookieValue(value = "myCookie", required = false) Cookie cookie) {
		System.out.println(cookie);
		Cookie cook = new Cookie("myCookie", "쿠키생성");
		cook.setMaxAge(10);
		response.addCookie(cook);
		return "cookie/cookie";
	}
}
