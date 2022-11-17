package com.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter how many elements in list");
		int n=sc.nextInt();
		ArrayList<Integer> alist=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			System.out.println("enter number");
			int num=sc.nextInt();
			alist.add(num);
		}
		System.out.println("Before Reverse");
		alist.stream().forEach(i->System.out.println(i));
		Collections.reverse(alist);
		System.out.println("AFTER Reverse");
		alist.stream().forEach(i->System.out.println(i));
	}
}
