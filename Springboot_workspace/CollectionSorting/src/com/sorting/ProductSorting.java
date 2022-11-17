package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductSorting {
	public static int id;
	public static String name;
	public static double price;
	public static int avl_qunity;
	public static void getDetails() {
		Scanner sc = new Scanner(System.in);
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
			Scanner sc = new Scanner(System.in); 
			char ch='y';
			ArrayList<Product> a =new ArrayList<Product>();
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
			do {
				System.out.println("enter sorting options \n 1.sort by id\n 2.sort by name\n 3.sort by price\n 4.sort by quantity");
				int option=sc.nextInt();
				if(option==1) {
					System.out.println("sorting by id");
					Collections.sort(a,new ProductComparatorById());
					System.out.println("sorting by id"+a);
				}
				else if(option==2) {
					System.out.println("sorting By name");
					Collections.sort(a,new ProductComparatorByname());
					System.out.println("sorting by name"+a);
				}
				else if(option==3) {
					System.out.println("sorting by price");
					Collections.sort(a,new ProductComparatorByprice());
					System.out.println("sorting by price"+a);
				}
				else if(option==4) {
					System.out.println("sorting by avl_quality");
					Collections.sort(a,new ProductComparatorByavlquanity());
					System.out.println("sorting by Quality"+a);
				}
				else {
					System.out.println("enter valid option for Sorting");
				}
				System.out.println("if you want contioune");
				ch=sc.next().charAt(0);
				if(ch=='n') {
					break;
				}			
			}while(ch=='y');
	}
}
