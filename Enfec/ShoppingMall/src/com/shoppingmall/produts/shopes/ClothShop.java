package com.shoppingmall.produts.shopes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.mallmanagement.customer.Customer;
import com.shoppingmall.produts.Products;


public class ClothShop extends Products implements Runnable{
	Customer cust;//customer class inherit has_A type relation
	//clothShop constructor creation
	public ClothShop(Customer cust) {
		super();
		this.cust=cust;
	}
	//toString method
	@Override
	public String toString() {
		return "ClothShop [product=" + product + "]";
	}
	List<Products> product = new Vector<Products>();//product store in product vector
	//getCloths method in implementations
	public synchronized void getCloths() throws InterruptedException {
		//declare variable
		String productName = null;
	    int quantity = 0;
	    int price1 = 0;
	    int totalPrice1 = 0;
	    double overAllPrice = 0.0;
	    char choice;
	    Scanner scan = new Scanner(System.in);
	    do {
		  System.out.println("Enter product details,");
		  System.out.print("cloth Type: ");
		  Thread.sleep(1000);
		  productName = scan.nextLine();
		  System.out.print("Quantity: ");
		  quantity = scan.nextInt();
		  System.out.print("cloth Price (per item): ");
		  price1 = scan.nextInt(); 
		  totalPrice1 = price1 * quantity;
		  overAllPrice += totalPrice1;
		  product.add( new Products(cust,productName, quantity, price1, totalPrice1) );
		  System.out.print("Want to add more item? (y or n): ");
		  choice = scan.next().charAt(0);
		  scan.nextLine();
		} while (choice == 'y' || choice == 'Y');
	    //products list display
	    for (Products p : product) {
	      p.display();
	    }
	    System.out.println("\nTotal Price = " + overAllPrice);
	}
	public List<Products> getProduct() {
		return product;
	}
	public void setProduct(List<Products> product) {
		this.product = product;
	}
//run method in Runnable interface
	public void run() {
		try {
			getCloths();//method calling
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }


