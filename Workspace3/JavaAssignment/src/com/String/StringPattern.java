package com.String;

import java.util.Scanner;

public class StringPattern {
	public static String findString(String str) {
		int l=str.length();
		String res="";
		if ( l<3 || (!str.contains("z") || !str.contains("p")) ) 
			return str;
		else {
			for (int i=0; i<l; i++){
				if (str.charAt(i)=='z' && str.charAt(i+2)=='p') {
				res+="z";
				res+="p";
				i+=2;
				}
			else res= res+ str.charAt(i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		System.out.println("After change Pattern :"+findString(str));

	}

}