import java.util.*;
public class Shape {
	String name;
	public Shape(String name) {
			super();
				this.name=name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s=new Shape("circle");
		Circle c=new Circle("circle",2);
		Square s1=new Square("Square",4);
		Triangle t=new Triangle("triangle",4,4);
	}

}
class Circle extends Shape
{
	int radius;
	double area;
	public Circle(String name,int radius) {
		super(name);
		this.radius=radius;
		draw();
		area(radius);
		erase();
	}
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
class Square extends Shape
{
	int side;
	double area;
	public Square(String name,int side) {
		super(name);
		this.side=side;
		draw();
		area(side);
		erase();
	}
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
class Triangle extends Shape
{
	int base,height;
	double area;
	public Triangle(String name,int base,int height) {
		super(name);
		this.base=base;
		this.height=height;
		draw();
		area(base,height);
		erase();
	}
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