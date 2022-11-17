package com.car;
class Car1{
	static int speed;
	static double regularPrice;
	static String color;
	double salePrice;
	public Car1(int speed, double regularPrice, String color) {
		super();
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
	}
	public double getSalePrice()
	{
		salePrice+=regularPrice;
		return salePrice;
	}
	public void display()
	{
		System.out.println("speed of car: "+speed+"kmph");
		System.out.println("regularPrice of car: "+regularPrice+"Rs");
		System.out.println("color of car: "+color);
	}
}
class Ford1 extends Car1
{
	int year;
	int manufacturerDiscount;
	
	public Ford1(int year,int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.year=year;
		this.manufacturerDiscount=manufacturerDiscount;
	}
	public double getSalePrice()
	{
		salePrice=regularPrice-manufacturerDiscount;
		return salePrice;
	}
	public void display()
	{
		super.display();
		System.out.println("regularPrice of car: "+year);
		System.out.println("DiscountPrice of car: "+manufacturerDiscount);
	}
}
class Sedan1 extends Car1
{
	int length;
	
	public Sedan1(int length) {
		super(speed, regularPrice, color);
		this.length=length;
	}
	public double getSalePrice()
	{	salePrice+=regularPrice;
		return salePrice;
	}
	public void display()
	{
		super.display();
		System.out.println("regularPrice of length: "+length);
		
	}
}
public class TestCar1 {
	public static void main(String[] args)
	{
		Car1 c=new Car1(120,500000,"white");
		c.getSalePrice();
		Car1 f=new Ford1(2020,20000);
		System.out.println("Ford car Details ");
		f.display();
		System.out.println("Ford salesPrice is "+f.getSalePrice());
		System.out.println("--------------------------");
		System.out.println("Sedan car Details ");
		Car1 s=new Sedan1(6);
		s.display();
		System.out.println("sedan salesPrice is: "+s.getSalePrice());
	}
	
}
