package com.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lexicographical_Order {
	public static void getSmallestAndLargest(String str,int k) {
		ArrayList<String> strList=new ArrayList<String>(); 
		for (int i = 0; i <= str.length() - k; i++) {
			//System.out.println(str.charAt(i));
            String str1= str.substring(i, i + k);
            //System.out.println(str1);
            strList.add(str1);
		}
		Collections.sort(strList);
		System.out.println(strList.get(0));
		System.out.println(strList.get(strList.size()-1));
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.next();
		System.out.println("Enter a size");
		int k=sc.nextInt();
		getSmallestAndLargest(str, k);
	}

}
