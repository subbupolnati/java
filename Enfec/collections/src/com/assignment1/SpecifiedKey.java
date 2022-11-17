package com.assignment1;

//Write a Java program to test if a map contains a mapping for the specified key?

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecifiedKey {
	public static int n;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter key ");
		n=sc.nextInt();
		
	}
	public static void main(String[] args) {
		Map hm=new LinkedHashMap();
		hm.put(100,256);
		hm.put(101, 40);
		hm.put(102, 265);
		hm.put(103, "subbu");
		hm.put(104, "polnati");
		getDetails();
		System.out.println(n+" key in map :"+hm.containsKey(n));
	}

}
