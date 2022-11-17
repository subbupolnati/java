package com.assignment1;
//Write a Java program to search an element in a array list?
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	public static int n;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter key ");
		n=sc.nextInt();
		
	}
	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add(10);
		a1.add(20);
		a1.add(30);
		a1.add(40);
		a1.add(50);
		getDetails();
		boolean b=a1.contains(n);
		if(b== true)
			System.out.println(n+" element found in Array list");
		else
			System.out.println(n+" element not  found in Array list");
		
		System.out.println("elements in array list :"+a1);
	}

}
