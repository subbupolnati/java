import java.util.Scanner;
class Account{
	int amount=1000;
	public  void deposit(int depo)throws InterruptedException
	{
		 synchronized (this)
         {  
			 this.amount+=depo;    
			 System.out.println("deposit successfully completed ");
			 System.out.println("Total balance:: "+this.amount);
			 notify();
			Thread.sleep(1000);
         }
	}
	public int withdraw(int withd) throws InterruptedException
	{
		 synchronized (this)
         {
			 if(this.amount<=withd)
			 {    
				 System.out.println("insufficent founds\n please deposit amount ");
				 System.out.println("enter a deposit amount");
				 try {
					 wait();
				 } catch (InterruptedException e) {
				
					 e.printStackTrace();
				 }
			 }
		this.amount-=withd;
		System.out.println("withdraw Successfully completed");
		System.out.println("after withdraw account balance :"+amount);
		notify();
		Thread.sleep(1000);
		return this.amount;
         }
	}
}
class Husband extends Thread
{
	int dep;
	Account a;
	Husband(Account a,int dep)
	{
		this.a=a;
		this.dep=dep;
		
		
	}
	@Override
	public void run()
	{
		try {
			a.deposit(dep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Wife extends Thread{
	int withd;
	Account a;
	Wife(Account a,int withd){
		this.a=a;
		this.withd=withd;
	}
	@Override
	public void run() {
		try {
			a.withdraw(withd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
public class TestBankAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Account a=new Account();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a withdraw amount");
		int withd=sc.nextInt();
		Wife t2=new Wife(a,withd);
		t2.start();
		int dep=sc.nextInt();
		Husband t1=new Husband(a,dep);
		t1.start();
		t1.join();
		t2.join();
		System.out.println("enter another thread");
		System.out.println("enter a deposit amount");
		int dep1=sc.nextInt();
		Husband t3=new Husband(a,dep1);
		t3.start();
		t3.join();
		System.out.println("enter a withdraw amount");
		int withd1=sc.nextInt();
		Wife t4=new Wife(a,withd1);
		t4.start();
		t4.join();
	}

}
