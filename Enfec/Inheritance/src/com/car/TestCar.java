package com.car;
class Car{
	int speed;
	double regularPrice;
	String color;
	double salePrice;
	public Car(int speed, double regularPrice, String color) {
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
class Ford extends Car
{
	int year;
	int manufacturerDiscount;
	
	public Ford(int speed, double regularPrice, String color,int year,int manufacturerDiscount) {
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
		System.out.println("speed of car: "+speed+"kmph");
		System.out.println("regularPrice of car: "+regularPrice+"Rs");
		System.out.println("color of car: "+color);
		System.out.println("regularPrice of car: "+year);
		System.out.println("DiscountPrice of car: "+manufacturerDiscount);
	}
}
class Sedan extends Car
{
	int length;
	
	public Sedan(int speed, double regularPrice, String color,int length) {
		super(speed, regularPrice, color);
		this.length=length;
	}
	public double getSalePrice()
	{	salePrice+=regularPrice;
		return salePrice;
	}
	public void display()
	{
		System.out.println("speed of car: "+speed+"kmph");
		System.out.println("regularPrice of car: "+regularPrice+"Rs");
		System.out.println("color of car: "+color);
		System.out.println("regularPrice of length: "+length);
		
	}
}
public class TestCar {
	public static void main(String[] args)
	{
		Car c=new Car(120,500000,"white");
		c.getSalePrice();
		Car f=new Ford(120,550000.0,"white",2020,20000);
		System.out.println("Ford car Details ");
		f.display();
		System.out.println("Ford salesPrice is "+f.getSalePrice());
		System.out.println("--------------------------");
		System.out.println("Sedan car Details ");
		Car s=new Sedan(150,805000,"gray",6);
		s.display();
		System.out.println("sedan salesPrice is: "+s.getSalePrice());
	}
	
}
