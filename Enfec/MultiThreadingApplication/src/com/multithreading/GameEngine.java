package com.multithreading;
class Rectangle extends Thread {
	public void run() {
		System.out.println(""+Thread.currentThread());
		area();
		perimeter();
	}

	void area() {
		int a=2,b=4;
		double Area=(a*b);
		System.out.println("area of Rectangle:" + Area);
		
	}

	void perimeter() {
		int a=2,b=4;
		int per=2*(a+b);
		System.out.println("rectangle perimeter:"+per);
		
	}
	
}
class Circle extends Thread{
	public int r=4;
	public void run() {
		System.out.println(""+Thread.currentThread());
		
		area();
		perimeter();
	}

	void area() {
		
		double Area=(3.14*r*r);
		System.out.println("area of circle:" + Area);
		
	}

	void perimeter() {
		double per=2 * 3.14* r;
		System.out.println("circle perimeter:"+per);
		
	}
}
public class GameEngine {

	public static void main(String[] args) {
		Rectangle r1=new Rectangle();
		Circle c=new Circle();
		r1.start();
		c.start();

	}

}
