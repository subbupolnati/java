package com.Assign;
import java.util.Scanner;
public class Date implements Printable {
	int day,mon,year;
	Scanner sc=new Scanner(System.in);
	
	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptDetails() {
		System.out.println("Enter day");
		day=sc.nextInt();
		System.out.println("enter month");
		mon=sc.nextInt();
		System.out.println("enter year");
		year=sc.nextInt();
	}

	@Override
	public void printDetails() {
		System.out.println("print Date :"+day+"-"+mon+"-"+year);
		
	}

}
