package com.assign;

import java.util.Scanner;

public class StringReplace {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter total String");
		String str=sc.nextLine();
		System.out.println("enter repalce String");
		String rep=sc.nextLine();
		System.out.println("enter new String");
		String newstring=sc.nextLine();
		String []str1=str.split(" ");
		String str2="";
		int n=str1.length;
		for(int i=0;i<n;i++) {
			if(str1[i].equals(rep)) {
				str1[i]=" "+newstring;
				str2+=str1[i];
			} 
			else
				str2+=" "+str1[i];
			}
		System.out.println("after replaceing "+str2);
	}

}
