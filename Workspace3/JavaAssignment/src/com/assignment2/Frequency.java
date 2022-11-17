package com.assignment2;

import java.util.Scanner;

public class Frequency {
	private static void findFrequency(String str) {
		int count;
		for(int i=48;i<58;i++) {
			count=0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)==i) {
					count++;
				}
			}
			System.out.print(count);
		}	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String str=sc.next();
		findFrequency(str);
	}
}
