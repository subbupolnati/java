package com.interthreadedcomm;

import java.util.Scanner;

class Product{
	int items=0;
	int n;
	//boolean available=false;
	synchronized int get()
	{
		if(this.items<2)
		{	System.out.println("insufficent items\n please add items ");
			try {
				wait();
			}
			catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		System.out.println("consuming products");
		System.out.println("Get"+n);
		this.items--;
		notify();
		return this.items;
	}
	
	synchronized void put(int n)
	{
		this.items+=1;
		//available=true;
		System.out.println("Put::"+this.items);
		notify();
	}
}
class Producer1 extends Thread{
	Product p;
	
	Producer1(Product p){
		this.p=p;
		new Thread(this,"Producer1").start();
		}
	public void run()
		{
			int i=0;
			int x=0;
			while(x<5)
			{
				p.put(i++);
				x++;
			}
	}
}
class Consumer1 extends Thread{
	
	Product p;
	Consumer1(Product p)
	{
		this.p=p;
		new Thread(this,"Consumer1").start();
	}
	public void run()
	{
			p.get();
			
	}
}
public class TestProduct {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Product p=new Product();
		Producer1 p1=new Producer1(p);
		Consumer1 c=new Consumer1(p);
			//System.out.println("enter items");
			

	}

}
