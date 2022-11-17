//reverse of string
package com.string1;
import java.util.Scanner;

public class StringRev {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		
		String rev="";
		String []str1=str.split(" ");
		
		int n=str1.length;
		for(int i=n-1;i>=0;--i) {
			rev+=" "+str1[i];
		}
		System.out.println("REVERSE String: "+rev);
	}

}
