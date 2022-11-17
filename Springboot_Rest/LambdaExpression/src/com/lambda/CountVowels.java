package com.lambda;

import java.util.Scanner;

interface Vowels{
	int countVowels(String str);
}
public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Vowels v=(str)->{
			int count=0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='e'||str.charAt(i)=='E'|| str.charAt(i)=='I'||str.charAt(i)=='i'||str.charAt(i)=='O'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='U')
				{
					count=count+1;
				}
			}
			return count;
		};
		
		System.out.println("enter String");
		String str=sc.next();
		
		System.out.println("Vowels in String:  "+v.countVowels(str));
	}

}
