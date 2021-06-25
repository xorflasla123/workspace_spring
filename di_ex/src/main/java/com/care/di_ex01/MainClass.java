package com.care.di_ex01;

public class MainClass {
	public static void main(String[] args) {
		STBean stb = new STBean();
		stb.setSt(new Student());
		stb.setName("홍길동");
		stb.setAge(20);
		stb.print();
	}
}
