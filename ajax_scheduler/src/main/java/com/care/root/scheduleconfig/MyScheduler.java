package com.care.root.scheduleconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
//@EnableScheduling
public class MyScheduler {
	@Scheduled(cron = "* * * * * *") //특정 시간 설정(매*(초 분 시 일 월 년)마다)
	public void testS() {
		System.out.println("매 초마다 실행됩니다"); //기능이 들어감
	}
}
