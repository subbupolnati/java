package com.interthreadedcomm;
import java.util.LinkedList;

class Product1
{    
    LinkedList list = new LinkedList();
    int capacity = 5;    
    public void produce(int n) throws InterruptedException
    {               
            synchronized (this)
            {                
                if (list.size() == capacity)
                {
                    wait();
                }
                System.out.println("Producer produced-"+ n);                
                list.add(n);
                System.out.println("Elements in the list"+list);
                notify();                
                Thread.sleep(1000);
            }
        
    }
    public void consume() throws InterruptedException
    {
    int val=0;   
            synchronized (this)
            {
                if (list.size() < 2)
                {
                    wait();
                }
                val = (int) list.removeFirst();                 
                System.out.println("Consumer consumed-"+ val);
                notify();
                Thread.sleep(1000);
            }        
    }
}
class Thd1 extends Thread
{
     Product1 p;
     public Thd1(Product1 p) {
        super();
        this.p = p;
      }
public void run()
    {
        try {
        	int i=0;
        	int x=1;
        	while(x<=10)
        	{        		
            p.produce(i++);
            x++;
        	}
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thd2 extends Thread
{
     Product1 p;
     public Thd2(Product1 p) {
       super();
       this.p = p;
     }
public void run()
    {
        try {
        	int i=0;
        	int x=1;
        	while(x<=3)
        	{
            p.consume();
            x++;
        	}
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
public class TestProduct1 {

   public static void main(String[] args) throws InterruptedException {
            Product1 p=new Product1();
            Thd1 t1=new Thd1(p);
            Thd2 t2=new Thd2(p);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
     }

}

