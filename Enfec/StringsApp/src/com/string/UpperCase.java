package com.string;
import java.util.*;
public class UpperCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				ch=(char)((int)str.charAt(i)-32);
				System.out.print(ch);
				}
			else {
				System.out.print(ch);
			}
		}
		
	}

}