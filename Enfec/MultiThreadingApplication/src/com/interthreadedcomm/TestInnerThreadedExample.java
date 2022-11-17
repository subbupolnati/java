package com.interthreadedcomm;
class Q {
	int n;
	boolean available=false;

	synchronized int get()
	{
		if(!available)
		{
			try {
			wait();
			}
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		System.out.println("Get"+n);
		available=false;
		notify();
		return n;
	}
	
	synchronized void put(int n)
	{
		if(available)
			try {
			wait();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		this.n=n;
		available=true;
		System.out.println("Put::"+n);
		notify();
	}

}
class Producer implements Runnable
{
	Q q;
	Producer(Q q)
	{
		this.q=q;
		new Thread(this,"Producer").start();
	}
	
	public void run()
	{
		int i=0;
		int x=1;
		while(x<=20)
		{
			q.put(i++);
			x++;
		}
	}

}
class Consumer implements Runnable
{
	Q q;
	Consumer(Q q)
	{
		this.q=q;
		new Thread(this,"Consumer").start();
	}
	public void run()
	{
		int i=0;
		int x=1;
		while(x<=20)
		{
			q.get();
			x++;
		}
	}
}
public class TestInnerThreadedExample {
	public static void main(String[] args) {
		
	// TODO Auto-generated method stub
		Q q=new Q();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
	}



}


