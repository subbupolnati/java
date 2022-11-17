package com.assignment1;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramTest {
	public static boolean findAnagram(String str1,String str2) {
		str1.replaceAll("s","");
		str2.replaceAll("s","");
		char[] str3=str1.toLowerCase().toCharArray();
		char[] str4=str2.toLowerCase().toCharArray();
		Arrays.sort(str3);
		Arrays.sort(str4);
		boolean status = true;
		if(str3.length==str4.length) {
			if(Arrays.equals(str3,str4))
				status=true;
			else
				status=false;
		}
		else
			status=false;
		return status;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first String");
		String str1=sc.next();
		System.out.println("Enter second String");
		String str2=sc.next();
		boolean res=findAnagram(str1, str2);
		if(res) {
			System.out.println("Anagrams");
		}else
			System.out.println("Not Anagrams");
		
	}

}
