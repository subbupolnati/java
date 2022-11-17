package com.lambda;

import java.util.Scanner;

interface Square{
	int square(int x);
}
public class SquareExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Square s=(x)->{
			return x*x;
		};
		System.out.println("enter number");
		int x=sc.nextInt();
		System.out.println("suqre of the number is= "+s.square(x));
		

	}

}
