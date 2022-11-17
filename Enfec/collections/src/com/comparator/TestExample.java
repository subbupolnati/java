package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product{
	int id;
	String name;
	double price;
	int available_quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", available_quantity="
				+ available_quantity + "]";
	}
	public Product(int id, String name, double price, int available_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.available_quantity = available_quantity;
	}
}
class ProductComparatorByName implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		
		return p1.name.compareTo(p2.name);
	}
	
}
class ProductComparatorById implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		if(p1.id<p2.id)
			return -1;
		else if(p1.id>p2.id)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByPrice implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		if(p1.price<p2.price)
			return -1;
		else if(p1.price>p2.price)
			return 1;
		else
			return 0;
		
	}
	
}
class ProductComparatorByAq implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		if(p1.available_quantity<p2.available_quantity)
			return -1;
		else if(p1.available_quantity>p2.available_quantity)
			return 1;
		else
			return 0;
		
	}
	
}
public class TestExample {
	public static int id;
	public static String name;
	public static double price;
	public static int available_quantity;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id:");
		id=sc.nextInt();
		System.out.println("enter name:");
		name=sc.next();
		System.out.println("enter price:");
		price=sc.nextDouble();
		System.out.println("enter available_quantity:");
		available_quantity=sc.nextInt();
	}
	public static void main(String[] args) {
		ProductComparatorByName nm=new ProductComparatorByName();
		ProductComparatorById pi=new ProductComparatorById();
		ProductComparatorByPrice pri=new ProductComparatorByPrice();
		ProductComparatorByAq aqt=new ProductComparatorByAq();
		ArrayList al=new ArrayList();
		Scanner sc=new Scanner(System.in);
		System.out.println("how many items are enterd");
		int n=sc.nextInt();
		int i=1;
		while(i<=n) {
			getDetails();
			al.add(new Product(id,name,price,available_quantity));
			i++;
		}
		/*getDetails();
		al.add(new Product(id,name,price,available_quantity));
		getDetails();
		al.add(new Product(id,name,price,available_quantity));*/
		char ch;
		do {
			System.out.println("select sorting order\n 1.sort by name\n 2.sort by id\n 3.sort by price\n 4.sort by available_quantity");
			int option=sc.nextInt();
			switch(option)
			{
			case 1: System.out.println("before sorting\n:"+al);
					Collections.sort(al,nm);
					System.out.println("after sorting\n: "+al);
					break;
			case 2: System.out.println("before sorting\n:"+al);
					Collections.sort(al,pi);
					System.out.println("after sorting\n: "+al);
					break;
			case 3: System.out.println("before sorting\n:"+al);
					Collections.sort(al,pri);
					System.out.println("after sorting\n: "+al);
					break;
			case 4: System.out.println("before sorting\n:"+al);
					Collections.sort(al,nm);
					System.out.println("after sorting\n: "+al);
					break;
			default:
					System.out.println("please select vaild option");
					break;
			}
			System.out.println(" Do u want continue y/n");
			ch=sc.next().charAt(0);
			if(ch=='n')
				break;
		}while(ch=='y');
		Collections.sort(al,pi);
		System.out.println("default sorting in id sorting\n: "+al);

	}

}
