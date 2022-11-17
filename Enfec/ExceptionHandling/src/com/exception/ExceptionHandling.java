package com.exception;

import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("enter number1");
	int num=sc.nextInt();
	System.out.println("enter number2");
	int num1=sc.nextInt();
	int num2=0;
	try {
		num2=num/num1;
	}
	catch(ArithmeticException ar) {
		System.out.println("cannot divided by 0");
	}
	System.out.println("divison is="+num2);
	}

}
