package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.lang.Comparable;
public class Products {
	public  int id;
	public  String name;
	public  double price;
	public  int avl_quantity;
	
	public Products(int id, String name, double price, int avl_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.avl_quantity = avl_quantity;
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", avl_quantity=" + avl_quantity + "]";
	}
	private static void searchMethod(Object[] a, String n) {
		for(Object s:a) {
				if(n.equals(s))
					System.out.println("item found in list"+n);
				else
					System.out.println("item not found in list");
				
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	ArrayList li  = new ArrayList();
	li.add(new Products(10,"laptop",25000.00,5));
	li.add(new Products(11,"mouse",250.00,10));
	li.add(new Products(19,"mobile",10000.00,15));
	li.add(new Products(15,"book",150.00,18));
	li.add(new Products(13,"keyboard",500.00,8));
	System.out.println(""+li);
	System.out.println("enter search item");
	String n=sc.next();
	Object a[]=li.toArray();
	searchMethod(a,n);
	

		
	}
	
}

