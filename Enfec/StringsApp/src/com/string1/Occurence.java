//number of occuerence of a specifiedd chrater
package com.string1;
import java.util.Scanner;

public class Occurence {

	public static void main(String[] args) {
		int count=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		System.out.println("enter search character");
		char s=sc.next().charAt(0);
		for(int i=0;i<str.length();i++) {
			if(s==str.charAt(i))
				count++;
		}
		System.out.println("search charcter is find in string "+count+" occurnces");
	}

}
