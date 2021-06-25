package com.care.di_test03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_test03.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		Student st = ctx.getBean("student", Student.class);
		st.execute();
		
		Student st1 = ctx.getBean("student1", Student.class);
		st1.execute();
	}
}
