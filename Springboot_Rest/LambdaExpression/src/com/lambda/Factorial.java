package com.lambda;

import java.util.Scanner;

interface Fact{
	int factorial(int n);
}
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Fact f=(n)->{
			int fact=1;
			while(n>=1) {
				fact=fact*n;
				n=n-1;
			}
			return fact;
		};
		System.out.println("enter number");
		int n=sc.nextInt();
		System.out.println("factorial of "+n+"is"+f.factorial(n));
	}
}
	
