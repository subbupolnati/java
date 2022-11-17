package com.Assign;
import java.util.*;
public class Shape implements Printable {
	String name;
	int r;
	Scanner sc=new Scanner(System.in);
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptDetails() {
		System.out.println("enter shape name");
		name=sc.next();
		System.out.println("enter radius");
		r=sc.nextInt();
	}
	void area() {
		System.out.println("area is ="+pi*r*r);
	}
	@Override
	public void printDetails() {
		System.out.println("shape name "+name);
		area();
		}
}
