import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Producer implements Runnable
{
	BlockingQueue queue;
	int len;
	Scanner sc=new Scanner(System.in);
	Producer(BlockingQueue queue,int len)
	{
		this.queue=queue;
		this.len=len;
		//System.out.println(len);
	}
	@Override
	public void run() 
	{
		for (int i = 0; i < len; i++)
		{
	          try {
	        	  	Thread.sleep(1000);
	        	  	System.out.println("enter elements");
	        	  	int num=sc.nextInt();
	        	  	queue.offer(num);
	                System.out.println("Produced "+(i+1)+"item :"+num);
	                Thread.sleep(1000);
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	       }
	}
}
class Consumer implements Runnable
{
	BlockingQueue queue;
	int len;
	Consumer(BlockingQueue queue,int len)
	{
		this.queue=queue;
		this.len=len;
	}
	@Override
	public void run() {
		for (int i = 0; i <len; i++) {
	          try {
	        	   
	                System.out.println("Consumed "+(i+1)+"item :"+queue.take());
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	}
}
public class BlockingQueueExample {
public static void main(String[] args) throws InterruptedException {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter how many elements entered");
	int n=sc.nextInt();
	BlockingQueue bq=new ArrayBlockingQueue(n);
	Producer p=new Producer(bq,n);
	Consumer q=new Consumer(bq,n);
	Thread t1=new Thread(p);
	Thread t2=new Thread(q);
	t1.start();
	t2.start();
	Thread.sleep(4000);
}
}