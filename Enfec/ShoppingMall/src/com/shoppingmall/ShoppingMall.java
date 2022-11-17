package com.shoppingmall;

import java.util.List;
import java.util.Scanner;

import com.mallmanagement.customer.Customer;
import com.shoppingmall.produts.Products;
import com.shoppingmall.produts.shopes.ClothShop;
import com.shoppingmall.produts.shopes.FurintureShop;
import com.shoppingmall.produts.shopes.MobileStore;
import com.shoppingmall.produts.shopes.MovieTheater;

public class ShoppingMall {
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Shopping Mall");
		System.out.println("enter customer id");
		int cid=sc.nextInt();
		System.out.println("enter customer name");
		String cname=sc.next();
		System.out.println("enter customer mobileno");
		long cmobile=sc.nextLong();
		Customer cust=new Customer(cid,cname,cmobile);//customer class object creation
		char ch = 0;
		do {
			System.out.println("select shopping complex");
			System.out.println("\n 1.ClothShop,\n 2.FurintureShop,\n 3.MobileStore\n 4.MovieTheater");
			int opt=sc.nextInt();
			switch(opt)
			{
			case 1:
				ClothShop c=new ClothShop(cust);//clothshop class object creation
				Thread t1=new Thread(c);
				t1.start();
				t1.join();
				break;
			case 2:
				FurintureShop fs=new FurintureShop(cust);//FurintureShop class object creation
				Thread t2=new Thread(fs);
				t2.start();
				t2.join();
				break;
			case 3:
				MobileStore ms=new MobileStore(cust);//mobile store object creation
				Thread t3=new Thread(ms);
				t3.start();
				t3.join();
				break;
			case 4:
				MovieTheater mt=new MovieTheater(cust);//movies object creation
				Thread t4=new Thread(mt);
				t4.start();
				t4.join();
				break;
			default:
				System.out.println("enter complex not in mall");
			}
		System.out.print("do you want contionue Shopping (y or n): ");
		ch = sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
		System.out.println("thank you for shopping visit again: "+cname);
	}

}
