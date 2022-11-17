package com.assignment1;

import java.util.Scanner;

public class SplitString {
	public static void stringSplit(String str) {
		if(str.length()==0) {
			System.out.println(" String length"+str.length());
		}
		else {
			String[] token = str.trim().split("[\\s!,?._'@]+");
	        System.out.println(token.length);
	        for (String string : token) {
	        	System.out.println(string);
	        }
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String str=sc.nextLine();
		stringSplit(str);
	}
}
