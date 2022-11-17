package com.lambda;

import java.util.Scanner;

interface EvenOrOdd{
	void even(int x);
}
public class Even {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EvenOrOdd e=(x)->{
			if(x%2==0) {
				System.out.println("enter"+x+"is Even");
			}
			else
				System.out.println("enter"+x+"is ODD");
		};
		System.out.println("enter a number");
		int x=sc.nextInt();
		e.even(x);
	}
}
