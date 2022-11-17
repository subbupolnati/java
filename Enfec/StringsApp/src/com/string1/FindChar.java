//search a character from string
package com.string1;
import java.util.Scanner;

public class FindChar {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int flag=0;
		System.out.println("enter String");
		String str=sc.nextLine();
		System.out.println("enter search character");
		char s=sc.next().charAt(0);
		for(int i=0;i<str.length();i++) {
			if(s==str.charAt(i)) {
				flag=1;
			}
		}
		if(flag==1)
			System.out.println("search charcter is find in string");
		else
			System.out.println("search charcter is find in string");
	}

}
