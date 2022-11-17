package com.string;
import java.util.*;
public class Length {
	public static void main(String[] args) {
		int count=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a string");
	String s=sc.nextLine();
	//System.out.println(s.length());
	for(int i=0;i<s.length();i++){
		char ch=s.charAt(i);
		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
		{
			count++;
		}
		
	}
	System.out.println("lenth of string:"+count);
	}

}
