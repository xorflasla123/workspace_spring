package com.care.di_test02;

public class OperationClass {
	private int result;
	
	public int operation(int a, int b, String c) {
		if(c.equals("+")) result = a + b;
		else if(c.equals("-")) result = a - b;
		else if(c.equals("/")) result = a / b;
		else result = a * b;
		return result;
	}
}
