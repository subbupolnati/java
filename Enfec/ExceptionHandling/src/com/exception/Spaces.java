package com.exception;

import java.util.Scanner;

public class Spaces {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String 1");
		String str=sc.nextLine();
		String s="";
		//String str1=str.replace(" ", "");
		//System.out.println(str1);
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				continue;
			}
			else {
				s+=str.charAt(i);
			}
		}
		System.out.print(s);
		
	}

}
