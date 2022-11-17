package com.onlineticketbooking;
import java.util.Scanner;

import com.onlineticketbooking.bookingsites.AirLineBooking;
import com.onlineticketbooking.bookingsites.BusTicketBooking;
import com.onlineticketbooking.bookingsites.MovieTicketBooking;
import com.onlineticketbooking.bookingsites.TrainBooking;
import com.onlineticketbooking.customer.Customer;
public class OnlineTicketBooking {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Online Ticket booking portal");
		System.out.println("enter customer id");
		int cid=sc.nextInt();
		System.out.println("enter customer name");
		String cname=sc.next();
		System.out.println("enter customer mobileno");
		long cmobile=sc.nextLong();
		System.out.println("enter customer adreess");
		String caddr=sc.next();
		Customer cust=new Customer(cid,cname,cmobile,caddr);
		char ch = 0;
		do {
			System.out.println("select booking portals");
			System.out.println("\n 1.AirLine Regervastion ,\n 2.Train Regervation,\n 3.Bus Regervastion\n 4.Movie Ticket Booking");
			int opt=sc.nextInt();
			switch(opt)
			{
			case 1:
				AirLineBooking ab=new AirLineBooking(cust);
				Thread t1=new Thread(ab);
				t1.start();
				t1.join();
				//ab.getDetials();
				break;
			case 2:
				TrainBooking tb=new TrainBooking(cust);
				Thread t2=new Thread(tb);
				t2.start();
				t2.join();
				break;
			case 3:
				BusTicketBooking btb=new BusTicketBooking(cust);
				Thread t3=new Thread(btb);
				t3.start();
				t3.join();
				break;
			case 4:
				MovieTicketBooking mtb=new MovieTicketBooking(cust);
				Thread t4=new Thread(mtb);
				t4.start();
				t4.join();
				break;
			default:
				System.out.println("enter invalid booking site");
			}
		System.out.print("do you want contionue booking (y or n): ");
		ch = sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
		System.out.println("thank you for booking visit again: "+cname);
	}
}

