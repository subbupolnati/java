package com.calculator;

public class Calculator {

	CalculatorService service;
	public Calculator(CalculatorService service) {
		super();
		this.service=service;
	}
	public int add(int a,int b) {
		return service.add(a, b);
	}
	public int sub(int a,int b) {
		return service.sub(a, b);
	}
	public int mul(int a,int b) {
		return service.mul(a, b);
	}
	public double div(int a,int b) {
		return service.div(a, b);
	}
}
