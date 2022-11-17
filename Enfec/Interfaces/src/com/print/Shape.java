package com.print;

public class Shape implements Printable {
	String name;
	public Shape(String name) {
		super();
		this.name = name;
		printData();
		draw();
		area();
	}
	public void printData() {
		System.out.println("print Shape details");
	}
	void draw() {
		System.out.println("draw a Shape :"+name);
	}
	void area() {
		System.out.println("Print area of :"+name+":"+(pi*2*2));
	}
}
