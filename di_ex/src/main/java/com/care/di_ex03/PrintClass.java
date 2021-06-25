package com.care.di_ex03;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintClass {
	public void print(String name, ArrayList hobby, HashMap weather) {
		System.out.println("이름 : "+name);
		System.out.println("hobby 0 : "+hobby.get(0));
		System.out.println("hobby 1 : "+hobby.get(1));
		System.out.println("오늘 날씨 : "+weather.get("오늘"));
		System.out.println("내일 날씨 : "+weather.get("내일"));
	}
}
