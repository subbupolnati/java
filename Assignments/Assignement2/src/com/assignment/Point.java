package com.assignment;
import java.util.Scanner;
public class Point {
	private int x,y;
	Scanner sc=new Scanner(System.in);
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
		super();
		System.out.println("enter x value");
		x=sc.nextInt();
		System.out.println("enter y value");
		y=sc.nextInt();
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setXY(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void display() {
		System.out.println("x value is: "+x);
		System.out.println("y value is: "+y);
	}
	public static void main(String[] args) {
	 Point p=new Point();
	 p.display();		 

	}
	

}
