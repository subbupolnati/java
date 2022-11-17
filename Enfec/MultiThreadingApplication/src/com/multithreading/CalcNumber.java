package com.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Prime extends Thread{
	ArrayList a=new ArrayList();
	public void run() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int n=sc.nextInt();
		int i,flag=0;
		if(n==0||n==1){
			System.out.println(n+"is not prime number");
		}
		else{
			for(i=2;i<n/2;i++){
				if(n%i==0){
					System.out.println(n+"is not prme number");
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println(n+"is prime number");
				a.add(n);
			}
		}
		System.out.println("prime number in arraylist"+a);
	}
}
class ArmStrong extends Thread{
	LinkedList l1=new LinkedList();
	public void run() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Number");
	int num=sc.nextInt();
	int temp,sum=0,rem,i;
	temp=num;
	while(num>0)
	{	
		rem=num%10;
		num=num/10;
		sum=sum+(rem*rem*rem);
	}
	if(temp==sum) {
		System.out.println("Aramstrong Number");
		l1.add(sum);
	}
	else
		System.out.println("Not an Aramstrong Number");
	System.out.println("Linked list in arm strong number"+l1);
	}
}
public class CalcNumber {

	public static void main(String[] args) {
		Prime p=new Prime();
		ArmStrong as=new ArmStrong();
		p.start();
		
		as.start();

	}

}

