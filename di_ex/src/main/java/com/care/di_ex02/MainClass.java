package com.care.di_ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		STBean stb = new STBean();
//		stb.setSt(new Student());
		
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		STBean stb = ctx.getBean("stb",STBean.class);
		
		stb.print();
		
		stb.setName("홍길동");
		stb.setAge(20);
		
		stb.print();
	}
}
