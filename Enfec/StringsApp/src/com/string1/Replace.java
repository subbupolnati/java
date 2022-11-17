package com.string1;

import java.util.Scanner;

public class Replace {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		char []re= new char[str.length()];
		System.out.println("enter repalce character");
		char s=sc.next().charAt(0);
		for(int i=0;i<str.length();i++) {
			if(s==str.charAt(i)) {
				re[i]='x';
			}
			else
				re[i]+=str.charAt(i);
		}
		System.out.println("enter repalce character");
		for(int i=0;i<re.length;i++) {
			System.out.print(re[i]);
		}
	}

}
