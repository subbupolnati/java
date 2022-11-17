package com.lambda;

import java.util.Scanner;
import java.util.function.Function;

public class ConvertLowertoUpperExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Function<String,String> f=(str)->{
			System.out.println(" Convert Lowercsae to uppercase:  "+str);
			return str;
		};
		System.out.println("enter string ");
		String str1=sc.next();
		String str=str1.toUpperCase();
		f.apply(str);
	}

}
