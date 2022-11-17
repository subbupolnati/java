package com.string3;

import java.util.Scanner;

public class Cofffe {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0,p=0;
		System.out.println("enter a string");
		String str=sc.nextLine();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c>=48 && c<=57) {
				n=n*10+c-48;
			}
			else
			{
				p+=n;
				n=0;
			}
		}
		System.out.println("price of "+(p+n));
	}

}
