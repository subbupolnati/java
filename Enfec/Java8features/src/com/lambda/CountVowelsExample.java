package com.lambda;

import java.util.Scanner;
import java.util.function.Function;

public class CountVowelsExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Function<String,Integer> f1=(str)->{
			int count=0;
			for(int i=0;i<str.length();i++) {
				//char s=str.charAt(i);
				if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='e'||str.charAt(i)=='E'|| str.charAt(i)=='I'||str.charAt(i)=='i'||str.charAt(i)=='O'||str.charAt(i)=='o'
						||str.charAt(i)=='u'||str.charAt(i)=='U')
				{
					
					count=count+1;
				}
			}
			return count;
		};
		System.out.println("enter String");
		String str=sc.next();
		
		System.out.println("Vowels in String:  "+f1.apply(str));

	}

}
