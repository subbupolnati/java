package com.assignment1;
//Write a Java program to update specific array element by given element?
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateArray {
	public static int pos;
	public static int num;
	public static void getdetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter position");
		pos=sc.nextInt();
		System.out.println("enter number");
		num=sc.nextInt();
		
	}
	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add(9);
		a1.add(20);
		a1.add(30);
		a1.add(40);
		a1.add(50);
		System.out.println("inserting elements in array list is :"+a1);
		try{
			getdetails();
		
			a1.set(pos,num);
		}
		catch(Exception e) {
			System.out.println("enter postion is not found in array list");
		}
		System.out.println("inserting elements in array list at the first position :"+a1);
	}

}
