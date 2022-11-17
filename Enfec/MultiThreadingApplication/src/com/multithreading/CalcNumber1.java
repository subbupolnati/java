package com.multithreading;
import java.util.*;
class Prime1 extends Thread
{	
	int a;
	
	public Prime1(int a) {
		super();
		this.a = a;
	}
	static ArrayList al=new ArrayList();

	public void run()
	{
		prime();
		
	}
	public void prime()
	{
		int count=0;
		
		for(int i=2;i<a;i++)
		{
			if(a%i==0)
			{
				count++;
			}
		}
			if(count>0)
			{
				//System.out.println("The number is not prime");
				
			}
			else
			{
				//System.out.println("The number is prime");
				//System.out.println("Stored in ArrayList");
				al.add(a);
			
			}
			
	}
	 public static void list()
	{
		Collections.sort(al);
		System.out.println("ArrayList:"+al);
	}
	
}

class Armstrong1 extends Thread
{
	int n;
	
	public Armstrong1(int n) {
		super();
		this.n = n;
	}
	static LinkedList l=new LinkedList();
	public void armstrong()
	{
		int k=n;
		int sum=0;
		int a=0;
		
		while(n>0)
		{
			a=n%10;
			sum=sum+(a*a*a);
			n=n/10;
		}
		if(k==sum)
		{
			//System.out.println("The number is Armstrong");
			//System.out.println("Stored in LinkedList");
			l.add(k);
		}
		else
		{
			//System.out.println("Number not armstrong");
		}
		
	}

	public void run()
	{
		
		armstrong();
	
	}
	public static  void lList()
	{
		Collections.sort(l);
		System.out.println("LinkedList:"+l);
	}
	
}
public class CalcNumber1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  numbers");
		int num[]=new int[5];
		for(int i=0;i<5;i++)
		{
			num[i]=sc.nextInt();
			 Prime1 p=new Prime1(num[i]);
			 p.start();
			
			 Armstrong1 am=new Armstrong1(num[i]);
			 am.start();
		}
		
		Prime1.list();
		Armstrong1.lList();
		
		
	}

}
