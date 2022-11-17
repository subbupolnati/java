//revesre of a string
package com.string1;
import java.util.*;
public class Reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String s=sc.nextLine();
		char c[]=s.toCharArray();
		String rev="";
		int n=0;
		for(char i: c){
			n++;
		}
		for(int i=n-1;i>=0;--i) {
			rev+=s.charAt(i);
		}
		System.out.println(rev);
	}

}
