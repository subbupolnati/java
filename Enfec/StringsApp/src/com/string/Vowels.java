package com.string;
import java.util.*;
public class Vowels {
	public static void main(String[] args) {
		int count=0,count1=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='e'||str.charAt(i)=='E'|| str.charAt(i)=='I'||str.charAt(i)=='i'||str.charAt(i)=='O'||str.charAt(i)=='o'
					||str.charAt(i)=='u'||str.charAt(i)=='U')
			{
				
				count=count+1;
			}
			else {
				count1+=1;
			}
			
		}
		System.out.println("total length of string::: "+str.length());
		System.out.println("number of vowels in string::: "+count);
		System.out.println("number of consonants in string::: "+count1);
	}

}
