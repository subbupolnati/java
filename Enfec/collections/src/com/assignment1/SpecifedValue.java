package com.assignment1;
//Write a Java program to test if a map contains a mapping for the specified value?
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecifedValue {
	public static String n;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter key ");
		n=sc.nextLine();
		
	}
	public static void main(String[] args) {
		Map hm=new LinkedHashMap();
		hm.put(100,"enfec");
		hm.put(101, "solutions");
		hm.put(102, "hyd");
		hm.put(103, "subbu");
		hm.put(104, "polnati");
		getDetails();
		System.out.println(n+" key in map :"+hm.containsValue(n));

	}

}
