//remove specified character from a string
package com.string1;
import java.util.Scanner;

public class Remove {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		String remove="";
		System.out.println("enter remove character");
		char s=sc.next().charAt(0);
		for(int i=0;i<str.length();i++) {
			if(s==str.charAt(i))
				continue;
			else
				remove+=str.charAt(i);
		}
		System.out.println("after remove character "+remove);
	}

}
