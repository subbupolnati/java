package com.string;
import java.util.*;
public class Concat {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a String1");
		String s=sc.nextLine();
		System.out.println("enter a String2");
		String s1=sc.nextLine();
		int index=0;
		//System.out.println("concat two strings "+(s+" "+s1));
		char s2[]=new char[s.length()+s1.length()];
		for(int i=0;i<s.length();i++) {
			s2[i]+=s.charAt(i);
			index=i;
		}
		index+=1;
		//System.out.println(index);
		for (int i=0;i<s1.length();i++) {
			s2[index]+=s1.charAt(i);
			index+=1;
		}
		System.out.print(s2);
		
	}
}
