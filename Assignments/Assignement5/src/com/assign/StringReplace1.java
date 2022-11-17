package com.assign;

import java.util.Scanner;

public class StringReplace1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter total String");
		String str=sc.nextLine();
		System.out.println("enter repalce String");
		String old=sc.nextLine();
		System.out.println("enter new String");
		String rep=sc.nextLine();
		
		int pos=str.indexOf(old);
		
		int len=old.length();
		
		String str2=str.substring(0,pos)+rep+str.substring(pos+len);
		
		System.out.println(str2);
	}

}
