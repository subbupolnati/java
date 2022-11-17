package com.exception;

import java.util.Scanner;

public class Decimal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter binary number");
		int n=sc.nextInt();
		int temp=n,rem;
		int decimal=0;
		
		int i=0;
		while(n!=0) {
			rem=n%10;
			n=n/10;
			decimal+=rem*Math.pow(2,i);
			i++;
		}
		System.out.println(""+temp+"  decimal number is: "+decimal);
	
		}
	}
