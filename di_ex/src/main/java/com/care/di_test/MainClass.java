package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_test.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		PrintBean pb = ctx.getBean("pb",PrintBean.class);
		//pb.setPrint("출력할 내용");
		pb.printString();
	}
}
