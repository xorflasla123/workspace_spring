package com.care.root.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class AOPConfig {
	//지정된 메소드를 어떤 시점(범위)에서 실행될지를 결정하는 annotation(around는 처음과 끝)
	@Around("execution(public String buy_form(..))")
	public void commonAop(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("==== 공통기능 시작 ====");
			joinpoint.proceed();
			System.out.println("==== 공통기능 종료 ====");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Before("execution(* com.care.root.tx.TestServiceImpl.buy(..))")
	public void commonAop02() {
		System.out.println("서비스 실행 전에 실행");
	}
}
