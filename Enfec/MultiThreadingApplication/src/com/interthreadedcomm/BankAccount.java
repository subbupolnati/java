package com.interthreadedcomm;

import java.util.Scanner;

class Account{
	int amount=1000;
	synchronized int withdraw(int withd)
	{
		if(this.amount<=withd){    
			System.out.println("insufficent founds\n please deposit amount ");
			System.out.println("enter a deposit amount");
			try {
				wait();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
		this.amount-=withd;
		System.out.println("withdraw Successfully completed");
		System.out.println("after withdraw account balance :"+amount);
		notify();
		return this.amount;
		
	}

	synchronized void deposit(int depo)
	{
		this.amount+=depo;    
		System.out.println("deposit successfully completed ");
		System.out.println("Total balance:: "+this.amount);
		notify();    
	}
}
class Husband implements Runnable
{
	int dep;
	Account a;
	Husband(Account a,int dep)
	{
		this.a=a;
		this.dep=dep;
		new Thread(this,"Husband").start();
	}
	@Override
	public void run()
	{
		a.deposit(dep);
	}
}
class Wife implements Runnable{
	int withd;
	Account a;
	Wife(Account a,int withd){
		this.a=a;
		this.withd=withd;
		new Thread(this,"Wife").start();
	}
	@Override
	public void run() {
		a.withdraw(withd);	
	}
}
public class BankAccount {

	public static void main(String[] args) {
		Account a=new Account();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a withdraw amount");
		int withd=sc.nextInt();
		Wife w=new Wife(a,withd);
		int dep=sc.nextInt();
		Husband h=new Husband(a,dep);
	}

}
