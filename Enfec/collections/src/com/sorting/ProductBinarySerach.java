package com.sorting;

import java.util.Comparator;
import java.util.*;
class Product{
	int id;
	String name;
	double price;
	int avl_qunity;
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
	public int getAvl_qunity() {
		return avl_qunity;
	}
	public void setAvl_qunity(int avl_qunity) {
		this.avl_qunity = avl_qunity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", avl_qunity=" + avl_qunity + "]";
	}
	public Product(int id, String name, double price, int avl_qunity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.avl_qunity = avl_qunity;
	}
	
}
class ProductComparatorById implements Comparator{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Product p1=(Product)ob1;
		Product p2=(Product)ob2;
		if(p1.id<p2.id)
			return -1;
		else if(p1.id>p2.id)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByname implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		return p1.name.compareTo(p2.name);
	}
	
}
class ProductComparatorByavlquanity implements Comparator{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Product p1=(Product)ob1;
		Product p2=(Product)ob2;
		if(p1.avl_qunity<p2.avl_qunity)
			return -1;
		else if(p1.avl_qunity>p2.avl_qunity)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByprice implements Comparator{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Product p1=(Product)ob1;
		Product p2=(Product)ob2;
		if(p1.price<p2.price)
			return -1;
		else if(p1.price>p2.price)
			return 1;
		else
			return 0;
	}
	
}
public class ProductBinarySerach {
	public static int id;
	public static String name;
	public static double price;
	public static int avl_qunity;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		id=sc.nextInt();
		System.out.println("enter product name");
		name=sc.next();
		System.out.println("enter product price");
		price=sc.nextDouble();
		System.out.println("enter ava_qunity");
		avl_qunity=sc.nextInt();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList a =new ArrayList();
		System.out.println("how many productes are entered");
		int n=sc.nextInt();
		int i=1;
		while(i<=n) {
			getDetails();
			a.add(new Product(id,name,price,avl_qunity));
			i++;
		}
		Collections.sort(a,new ProductComparatorById());
		System.out.println("after sorting "+a);
		System.out.println("enter searching options \n 1.search by id\n 2.search by name\n 3.search by price\n 4.search by quantity");
		int option=sc.nextInt();
		if(option==1) {
			System.out.println("enter pid for search");
			int id=sc.nextInt();
			Product p=new Product(id,null,0,0);
			int index=Collections.binarySearch(a,p,new ProductComparatorById());
			if(index<0)
					System.out.println("element not found");
			else
				System.out.println("element found"+index);
		}
		else if(option==2) {
			System.out.println("enter product  name for search");
			String nm=sc.next();
			Product p=new Product(0,nm,0,0);
			int index=Collections.binarySearch(a,p,new ProductComparatorByname());
			if(index<0)
					System.out.println("name not found");
			else
				System.out.println("name found"+index);
		}
		else if(option==3) {
			System.out.println("enter product price for search");
			double pr=sc.nextDouble();
			Product p=new Product(0,null,pr,0);
			int index=Collections.binarySearch(a,p,new ProductComparatorByprice());
			if(index<0)
				System.out.println("price not found");
			else
				System.out.println("price found"+index);
		
		}
		else if(option==4) {
			System.out.println("enter product  quanity for search");
			String nm=sc.next();
			Product p=new Product(0,nm,0,0);
			int index=Collections.binarySearch(a,p,new ProductComparatorByavlquanity());
			if(index<0)
				System.out.println("quanity not found");
			else
				System.out.println("qunity found"+index);
		}
		else {
			System.out.println("enter valid option for search");
		}
	}
}
