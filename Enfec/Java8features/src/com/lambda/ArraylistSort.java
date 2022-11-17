package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArraylistSort {
	public static int num;
	public static void addNumbers() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		num=sc.nextInt();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> al=new ArrayList<Integer>();
		System.out.println("enter how many elements to add");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			addNumbers();
			al.add(num);
		}
		System.out.println("before Sorting "+al);
		Comparator<Integer> c=(i1,i2)->(i1<i2)?-1:(i1>i2)?1:0;
		Collections.sort(al,c);
		System.out.println("after Sorting "+al);
	}

}
