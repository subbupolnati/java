package com.exception;

import java.util.Scanner;

public class Remove {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String 1");
		String str1=sc.nextLine();
		System.out.println("enter String 2");
		String str2=sc.nextLine();
		String r=" ";
		System.out.println("enter remove character");
		char s=sc.next().charAt(0);
		for(int i=0;i<str1.length();i++) {
			if(s==str1.charAt(i)){
				for(int j=0;j<str2.length();j++) 
				{
					if(s==str2.charAt(j)) {
						continue;
					}
				}
				
			}
			else
				r+=str1.charAt(i);
		}
		System.out.println("After remove character in string "+r);	
		}

	}

