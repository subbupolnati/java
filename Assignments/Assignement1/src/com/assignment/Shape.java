package com.assignment;
import java.util.Scanner;
abstract class Shape
{
	Scanner sc=new Scanner(System.in);
	String name;
	abstract void area();
	abstract void perimeter();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Shape s=new Circle(4);
		Shape s=new Circle();
		s.area();
		s.perimeter();
		System.out.println("_________________________");
		//Shape r=new Rectangle(4,6);
		Shape r=new Rectangle();
		r.area();
		r.perimeter();
		System.out.println("_________________________");
		//Shape t=new Triangle(2,4,3,5,6);
		Shape t=new Triangle();
		t.area();
		t.perimeter();
	}
}
class Circle extends Shape
{
	int r;

	public Circle(int r) {
		super();
		this.r = r;
	}
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
		getDetails();
	}
	void getDetails() {
		System.out.println("Enter radius");
		r=sc.nextInt();
	}
	void area()
	{
		double area=3.14*r*r;
		System.out.println("circle area is : "+area);
	}
	void perimeter()
	{
		double perimeter=2*(3.14*r);
		System.out.println("circle Perimeter  is : "+perimeter);
	}
}
class Rectangle extends Shape
{
	int w,h;

	public Rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	public Rectangle() {
		super();
		getDetails();
		}
	void getDetails() {
		System.out.println("Enter width");
		w=sc.nextInt();
		System.out.println("Enter height");
		h=sc.nextInt();
	}
	void area()
	{
		double area=w*h;
		System.out.println("Rectangle area is : "+area);
	}
	void perimeter()
	{
		double perimeter=2*(w+h);
		System.out.println("Rectangle Perimeter  is : "+perimeter);
	}
}
class Triangle extends Shape
{
	int base,height,a,b,c;

	public Triangle(int base, int height, int a, int b, int c) {
		super();
		this.base = base;
		this.height = height;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangle() {
		super();
		getDetails();
	}
	void getDetails() {
		System.out.println("Enter width");
		base=sc.nextInt();
		System.out.println("Enter height");
		height=sc.nextInt();
		System.out.println("Enter a value");
		a=sc.nextInt();
		System.out.println("Enter b value");
		b=sc.nextInt();
		System.out.println("Enter c value");
		c=sc.nextInt();
	}
	void area()
	{
		double area=(base*height)/2;
		System.out.println("Triangle area is : "+area);
	}
	void perimeter()
	{
		double perimeter=a+b+c;
		System.out.println("Triangle Perimeter  is : "+perimeter);
	}
}
	
