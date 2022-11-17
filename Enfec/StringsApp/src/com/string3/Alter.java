package com.string3;
import java.util.*;
public class Alter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String s=sc.nextLine();
		char[]c=s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(i==c.length-1)
				break;
			System.out.println(c[i]+" alternative chracter "+c[i+1]);
		}
		
	}

}
