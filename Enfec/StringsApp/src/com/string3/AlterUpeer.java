package com.string3;

import java.util.Scanner;

public class AlterUpeer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String s=sc.nextLine();
		char c[]=s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(i==s.length()-1)
				break;
			c[i+1]=(char)(c[i+1]-32);
			System.out.println(c[i]+" alternative upper case latter:: "+c[i+1]);
			c[i+1]=(char)(c[i+1]+32);	
			
			}
	}

}
