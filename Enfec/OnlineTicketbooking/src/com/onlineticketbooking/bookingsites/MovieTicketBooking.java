package com.onlineticketbooking.bookingsites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.onlineticketbooking.customer.Customer;

public class MovieTicketBooking implements Runnable {
	Customer cust;
	ArrayList<MovieTicketBooking> movies=new ArrayList<MovieTicketBooking>();
	public MovieTicketBooking(Customer cust) {
		super();
		this.cust = cust;
	}
	public String movie_name;
	public String theater_name;
	public double ticket_price;
	
	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	@Override
	public String toString() {
		return "MovieTicketBooking [cust=" + cust + ", movie_name=" + movie_name + ", theater_name=" + theater_name
				+ ", ticket_price=" + ticket_price + "]";
	}
	
	public MovieTicketBooking(String movie_name, String theater_name, double ticket_price) {
		super();
		this.movie_name = movie_name;
		this.theater_name = theater_name;
		this.ticket_price = ticket_price;
	}

	void movie_list() {
		movies.add(new MovieTicketBooking("RRR","Prasad Imax",250));
		movies.add(new MovieTicketBooking("spider man","Asian Pride",120));
		movies.add(new MovieTicketBooking("bhemla nayak","multiflex-screen-1",150));
		movies.add(new MovieTicketBooking("f3","multiflex-screen-2",150));
	}
	public synchronized void getDetails() {
		movie_list();
		String movie_name;
		String date;
		int number_of_tickets;
		String show_time;
		double total_amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter movie name");
		movie_name=sc.next();
		System.out.println("enter Show Time");
		show_time=sc.next();
		System.out.println("enter how many tickets");
		number_of_tickets=sc.nextInt();
		System.out.println("enter  date");
		date=sc.next();
		movie_name.equalsIgnoreCase(movie_name);
		Collections.sort(movies,new MovieByName());
		MovieTicketBooking tr=new MovieTicketBooking(movie_name,null,0);
		int index=Collections.binarySearch(movies,tr,new MovieByName());
		
		if(index<0)
			System.out.println("Movie is not availble");
		else
		{
			System.out.println("*****************print Ticket******************");
			System.out.println("Movie name            :"+movies.get(index).getMovie_name());
			System.out.println("Theater_name          :"+movies.get(index).getTheater_name());
			System.out.println("number of Tickets     :"+number_of_tickets);
			System.out.println("Show Time             :"+show_time);
			System.out.println("Date                  :"+date);
			total_amount=movies.get(index).getTicket_price()*number_of_tickets;
			System.out.println("Toatalticket price    :"+total_amount);
		}
		
	}
	@Override
	public void run() {
		try {
			getDetails();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
class MovieByName implements Comparator<MovieTicketBooking>{
	@Override
	public int compare(MovieTicketBooking o1, MovieTicketBooking o2) {
		// TODO Auto-generated method stub
		return o1.movie_name.compareTo(o2.movie_name);
	}
	
}