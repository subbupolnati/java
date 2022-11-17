package com.shoppingmall.produts.shopes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mallmanagement.customer.Customer;
import com.shoppingmall.produts.Products;

public class FurintureShop extends Products implements Runnable {
	List<Products> furniture = new ArrayList<Products>();//furniture store in furniture Arraylist
	Customer cust;//customer class inherit has_A type relation
	//constructor creation with customer arguments
	public FurintureShop(Customer cust) {
		super();
		this.cust = cust;
	}
	//to string method
	@Override
	public String toString() {
		return "FurintureShop [cust=" + cust + "]";
	}
	//method implementation getFurinture method
	public synchronized void getFurinture() throws InterruptedException{
		String productName = null;
	    int quantity = 0;
	    int price1 = 0;
	    int totalPrice1 = 0;
	    double overAllPrice = 0.0;
	    char choice;
	    Scanner scan = new Scanner(System.in);
	    do {
	      System.out.println("Enter product details,");
	      System.out.print("Furinture Name: ");
	      productName = scan.nextLine();
	      System.out.print("Quantity: ");
	      quantity = scan.nextInt();
	      System.out.print("Furinture Price (per item): ");
	      price1 = scan.nextInt();
	      totalPrice1 = price1 * quantity;
	      overAllPrice += totalPrice1;
	      furniture.add( new Products(cust,productName, quantity, price1, totalPrice1) );
	      System.out.print("Want to add more item? (y or n): ");
	      choice = scan.next().charAt(0);
	      scan.nextLine();
	    } while (choice == 'y' || choice == 'Y');
	    for (Products p : furniture) {
	      p.display();
	    }
	    System.out.println("\nTotal Price = " + overAllPrice);
	}
	public void run() {
		try {
			getFurinture();
			System.out.println("thread"+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
