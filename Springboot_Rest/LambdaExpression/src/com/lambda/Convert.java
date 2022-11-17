package com.lambda;

import java.util.Scanner;

interface LowerToUpper{
	String lowerToUpper(String name);
}
public class Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		LowerToUpper ltu=(name)->{
			String rename=name.toUpperCase();
			return rename;
		};
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("Convert to lower case to upper case::"+ltu.lowerToUpper(name));
	}

}
