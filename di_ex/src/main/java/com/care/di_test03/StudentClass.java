package com.care.di_test03;

import java.util.ArrayList;

public class StudentClass implements Student{
	private String name;
	private ArrayList<String> food;
	private PrintClass pc;
	
	public StudentClass() {}
	public StudentClass(String name, ArrayList food) {
		this.name = name;
		this.food = food;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pc.print(name, food);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getFood() {
		return food;
	}

	public void setFood(ArrayList<String> food) {
		this.food = food;
	}

	public PrintClass getPc() {
		return pc;
	}

	public void setPc(PrintClass pc) {
		this.pc = pc;
	}
}
