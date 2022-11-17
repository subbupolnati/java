package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortExample {
	public static String str;
	public static String getStr() {
		return str;
	}
	public static void setStr(String str) {
		SortExample.str = str;
	}
	public static void addNames() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter string");
		str=sc.next();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("enter how many elements to add");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			addNames();
			al.add(str);
		}
		System.out.println("before Sorting "+al);
		Comparator<SortExample> c=(o1,o2)->o1.getStr().compareTo(o2.getStr());
		//Collections.sort(al,c);
		System.out.println("after Sorting "+c);
	
}
}
