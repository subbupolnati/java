//check string is palendrome are not
package com.string1;
import java.util.*;
public class Palendrom {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String s=sc.nextLine();
		int n=s.length();
		String reverse="";
		for(int i=(n-1);i>=0;i--) {
			reverse+=s.charAt(i);
		}
		if(s.equals(reverse)){
			System.out.println("enter String is palendrom");
		}
		else
			System.out.println("enter String is not palendrom");
	}
}
