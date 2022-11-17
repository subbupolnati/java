package com.lambda;

import java.util.Scanner;

interface SquareEx{
	int square(int x);
}
public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		SquareEx s=(x)->{
			return (x*x);
		};
		System.out.println("enter number");
		int x=sc.nextInt();
		System.out.println("Square of number is="+s.square(x));
	}

}
