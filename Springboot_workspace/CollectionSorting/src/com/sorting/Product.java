package com.sorting;

import java.util.Comparator;

public class Product {
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
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
class ProductComparatorById implements Comparator<Product>{

	@Override
	public int compare(Product ob1, Product ob2) {
		
		Product p1=ob1;
		Product p2=ob2;
		if(p1.id<p2.id)
			return -1;
		else if(p1.id>p2.id)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByname implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		Product p1=o1;
		Product p2=o2;
		return p1.name.compareTo(p2.name);
	}
	
}
class ProductComparatorByavlquanity implements Comparator<Product>{

	@Override
	public int compare(Product ob1,Product ob2) {
		
		Product p1=ob1;
		Product p2=ob2;
		if(p1.avl_qunity<p2.avl_qunity)
			return -1;
		else if(p1.avl_qunity>p2.avl_qunity)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByprice implements Comparator<Product>{

	@Override
	public int compare(Product ob1, Product ob2) {
		
		Product p1=ob1;
		Product p2=ob2;
		if(p1.price<p2.price)
			return -1;
		else if(p1.price>p2.price)
			return 1;
		else
			return 0;
	}
	
}

