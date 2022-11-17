package com.shoppingmall.produts.shopes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.mallmanagement.customer.Customer;
import com.shoppingmall.produts.Movies;
import com.shoppingmall.produts.Products;

public class MovieTheater extends Movies implements Runnable {
	Customer cust;//customer class inherit has_A type relation
	List<Movies> movie = new ArrayList<Movies>();//Array list creation in movie details
	//constructor MovieTheator
	public MovieTheater(Customer cust) {
		super();
		this.cust = cust;
	}
	//toString
	@Override
	public String toString() {
		return "MovieTheater [cust=" + cust + "]";
	}
	//getTicket method implementation
	public synchronized void getTicket() throws InterruptedException{
		String movieName = "RRR";
	    int tickets = 0;
	    double price1 = 0.0;
	    double totalPrice1 = 0.0;
	    double overAllPrice = 0.0;
	    char choice;
	    Scanner scan = new Scanner(System.in);
	    do {
	      System.out.println("Enter product details,");
	      System.out.print("Movie Name: "+movieName);
	      //movieName = scan.nextLine();
	      System.out.print("\n Tickets: ");
	      tickets= scan.nextInt();
	      System.out.print("Tickets Price (per item): ");
	      price1 = scan.nextDouble();
	      totalPrice1 = price1 * tickets;
	      overAllPrice += totalPrice1;
	      movie.add( new Movies(cust,movieName,tickets,price1,totalPrice1));
	      System.out.print("Want to add more item? (y or n): ");
	      choice = scan.next().charAt(0);
	      scan.nextLine();
	    } while (choice == 'y' || choice == 'Y');
	    for (Movies p :movie) {
	    	p.display();
	    }
	    System.out.println("\nTotal Price = " + overAllPrice);
	}
	@Override
	public void run() {
		try {
			getTicket();
			//System.out.println("thread"+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
