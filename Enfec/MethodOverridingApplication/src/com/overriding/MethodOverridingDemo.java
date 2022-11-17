package com.overriding;

	class Circle
	{
		int radius;
		double area;
		void draw() {
			System.out.println("draw a circle");
		}
		void area(int radius) {
			
			area=3.14*radius*radius;
			System.out.println("area of circle is: "+area);
		}
		void erase() {
			System.out.println("earse circle");
			System.out.println("____________________________");
		}
	}
	class Square extends Circle
	{
		int side;
		double area;
		
		void draw() {
			System.out.println("draw a square");
		}
		void area(int side) {
			
			area=side*side;
			System.out.println("area of square is: "+area);
		}
		void erase() {
			System.out.println("earse Square");
			System.out.println("____________________________");
		}
	}
	class Triangle extends Circle
	{
		int base,height;
		double area;
		
		void draw() {
			System.out.println("draw a Triangle");
		}
		void area(int base,int height) {
			
			area=(base*height)/2;
			System.out.println("area of Triangle is: "+area);
		}
		void erase() {
			System.out.println("earse Triangle");
		}
	}
public class MethodOverridingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c=new Circle();
		c.draw();
		c.area(2);
		c.erase();
		Square s1=new Square();
		s1.draw();
		s1.area(4);
		s1.erase();
		Triangle t=new Triangle();
		t.draw();
		t.area(4,4);
		t.erase();

	}

}
