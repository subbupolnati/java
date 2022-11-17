package com.string3;

import java.util.Scanner;

public class Square {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String s=sc.nextLine();
		int sum=1;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			
			if(ch>=48 && ch<=57) {
				
				sum=(ch-48)*(ch-48);
				System.out.println("square of"+ch+"is"+sum);
			}
		}

	}

}
