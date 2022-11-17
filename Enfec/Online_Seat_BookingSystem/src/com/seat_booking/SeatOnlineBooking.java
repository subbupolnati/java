package com.seat_booking;
import java.util.Scanner;

import com.seat_booking_sites.AirLinesBooking;
import com.seat_booking_sites.BusSeatBooking;
import com.seat_booking_sites.MovieSeatBooking;
import com.seat_booking_sites.TrainBooking;
//main portal
public class SeatOnlineBooking {
	//airlines booking portal object creation method body
	private static void airlineRegervation() throws InterruptedException {
		AirLinesBooking airlinebooking=new AirLinesBooking();
		Thread t1=new Thread(airlinebooking);
		t1.start();
		t1.join();
	}
	//train booking portal object creation method body
	private static void trainRegervation() throws InterruptedException {
		TrainBooking trainbooking=new TrainBooking();
		Thread t2=new Thread(trainbooking);
		t2.start();
		t2.join();
	}
	//movie seat booking portal object creation method definition
	private static void MovieTIcketRegervation() throws InterruptedException {
		MovieSeatBooking movieticket=new MovieSeatBooking();
		Thread t4=new Thread(movieticket);
		t4.start();
		t4.join();
	}
	//bus ticket booking portal object creation method body
	private static void BusRegervation() throws InterruptedException {
		BusSeatBooking busbooking=new BusSeatBooking();//bus ticket reservation
		Thread t3=new Thread(busbooking);
		t3.start();
		t3.join();
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		//login details
		System.out.println("please enter login details");
		String loginname="subbu";
		String pass="1234";
		System.out.println("enter user name");
		String lname=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		//login details checking
		if(lname.equals(loginname) && password.equals(pass) ) {
			System.out.println("Welcome to Online Seat booking portal");
			char ch = 0;
			do {
				//select booking portals
				System.out.println("select booking portals");
				System.out.println("\n 1.AirLine Regervastion ,\n 2.Train Regervation,\n 3.Bus Regervastion\n 4.Movie Ticket Booking");
				int opt=sc.nextInt();
				switch(opt)
				{
				case 1:
					airlineRegervation();//airline seat booking method calling
					break;
				case 2:
					trainRegervation();//train ticket booking method calling
					break;
				case 3:
					BusRegervation();//bus ticket booking method calling
					break;
				case 4:
					MovieTIcketRegervation();//movie ticket method calling
					break;
				default:
					System.out.println("enter invalid booking site");
				}
			System.out.print("do you want contionue booking (y or n): ");
			ch = sc.next().charAt(0);
			}while(ch=='y'||ch=='Y');
			System.out.println("thank you for booking visit again: ");
		}
		else
			System.out.println("please enter correct username and password");
	}
}
