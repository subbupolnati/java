package com.lambda;

import java.util.Scanner;

interface EvenOrOdd{
	void evenorodd(int x);
}
public class EvenExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EvenOrOdd e=(x)->{
			if(x%2==0) 
				System.out.println("number "+x+" is Even");
			else 
				System.out.println("number "+x+" is odd");
			};
			System.out.println("enter number is");
			int x=sc.nextInt();
			e.evenorodd(x);
	}

}
