package com.care.di_test03;

import java.util.ArrayList;

public class PrintClass {
	public void print(String name, ArrayList food) {
		System.out.println("이름 : "+name);
		System.out.println("food 1 : "+food.get(0));
		System.out.println("food 2 : "+food.get(1));
		System.out.println("food 3 : "+food.get(2));
	}
}
