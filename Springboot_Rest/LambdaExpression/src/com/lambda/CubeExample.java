package com.lambda;

import java.util.Scanner;

@FunctionalInterface
interface Cube{
	int cube(int x);
}
public class CubeExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Cube c=(x)->{
			return (x*x*x);
		};
		System.out.println("enter a number");
		int x=sc.nextInt();
		System.out.println("cube is"+c.cube(x));
	}
	
}
