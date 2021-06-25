package com.care.di_ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void subFunc() {
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		Car car = ctx.getBean("controller", Car.class);
		//Car car = new Controller02();
		System.out.println("서브클래스가 속력을 냅니다");
		car.speed();
	}
}
