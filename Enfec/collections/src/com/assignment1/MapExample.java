package com.assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Write a Java program to test if a map contains a mapping for the specified key?
public class MapExample {
	
	public static int n;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter key ");
		n=sc.nextInt();
		
	}
	public static void main(String[] args) {
		
		Map hm=new HashMap();
		hm.put(100,256);
		hm.put(101, 40);
		hm.put(102, 265);
		hm.put(103, "subbu");
		hm.put(104, "polnati");
		getDetails();
		System.out.println(n+" key in map :"+hm.containsKey(n));
		//System.out.println("103 value in map :"+hm.containsValue("subbu"));
		//System.out.println("105 key in map :"+hm.containsKey(105));

	}


}
