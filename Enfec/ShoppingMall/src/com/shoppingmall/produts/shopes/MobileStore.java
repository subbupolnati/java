package com.shoppingmall.produts.shopes;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.mallmanagement.customer.Customer;
import com.shoppingmall.produts.Products;
public class MobileStore extends Products implements Runnable{
	List<Products> mobile = new LinkedList<Products>();//mobile information store in Arraylist
	Customer cust;//customer class inherit has_A type relation
	//constructor 
	public MobileStore(Customer cust) {
		super();
		this.cust = cust;
	}
	//getMobile method details implementation 
	public synchronized void getMobile() throws InterruptedException{
		String productName = null;
	    int quantity = 0;
	    int price1 = 0;
	    int totalPrice1 = 0;
	    double overAllPrice = 0.0;
	    char choice;
	    Scanner scan = new Scanner(System.in);
	    do {
	      System.out.println("Enter product details,");
	      System.out.print("Mobile Name: ");
	      productName = scan.nextLine();
	      System.out.print("Quantity: ");
	      quantity = scan.nextInt();
	      System.out.print("Mobile Price (per item): ");
	      price1 = scan.nextInt();
	      totalPrice1 = price1 * quantity;
	      overAllPrice += totalPrice1;
	      mobile.add( new Products(cust,productName, quantity, price1, totalPrice1) );
	      System.out.print("Want to add more item? (y or n): ");
	      choice = scan.next().charAt(0);
	      scan.nextLine();
	    } while (choice == 'y' || choice == 'Y');
	    for (Products p :mobile) {
	      p.display();
	    }
	    System.out.println("\nTotal Price = " + overAllPrice);
	}
	@Override
	public void run() {
		try {
			getMobile();
			System.out.println("thread"+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
