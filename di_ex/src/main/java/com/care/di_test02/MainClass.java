package com.care.di_test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		int a, b;
		String c;
		System.out.print("첫 번째 수 : ");
		a = sc1.nextInt();
		System.out.print("계산 할 수식 : ");
		c = sc1.next();
		System.out.print("두 번째 수 : ");
		b = sc1.nextInt();
		sc1.close();
		
		String path = "classpath:application_test02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		
		sc.setNum1(a); sc.setNum2(b); sc.setOp(c);
		
		sc.operationClass();
		sc.printClass();
	}
}
