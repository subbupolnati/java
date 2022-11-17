package com.String;

import java.util.Scanner;

public class Chocolate {
	public static int makeChocolate(int s, int b, int g) {
		   if (b*5 +s<g) 
			   return -1;
		   if (b*5 <= g) 
			   return g-b * 5;
		   return g % 5;
		   
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter small bars");
		int s=sc.nextInt();
		System.out.println("enter Big bars");
		int b=sc.nextInt();
		System.out.println("enter goal");
		int g=sc.nextInt();
		System.out.println(makeChocolate(s,b,g));

	}

}
