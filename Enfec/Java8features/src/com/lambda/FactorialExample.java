package com.lambda;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class FactorialExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		IntConsumer c=(x)->{
			int fact=1,num=x;
			while(x>=1) {
				fact=fact*x;
				x=x-1;
			}
			System.out.println("enter "+num+" factorial is: "+fact);
		};
		System.out.println("enter number");
		int x=sc.nextInt();
		c.accept(x);
	}

}
