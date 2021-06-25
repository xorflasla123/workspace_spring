package com.care.di_ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationPC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		sc.pcFunt();
		
		SaveClass sc1 = ctx.getBean("sc1", SaveClass.class);
		sc1.pcFunt();
	}
}
