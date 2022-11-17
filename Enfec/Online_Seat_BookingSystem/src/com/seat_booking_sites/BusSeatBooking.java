package com.seat_booking_sites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import com.seat_booking_customers.Customer;
import com.seat_booking_customers.Customerdetails;
//create BusSeatBooking class 
public class BusSeatBooking implements Customerdetails,Transport_Info,Runnable {
	Customer cust;//customer module inherit the has-A type relation
	ArrayList<BusSeatBooking> bus_info=new ArrayList<BusSeatBooking>();//store bus information in Array list
	//Declare variables
	public String bus_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
	
	//no_argument constructor
	public BusSeatBooking() {
		super();
	}
	//toString method
	@Override
	public String toString() {
		return "BusSeatBooking [cust=" + cust + ", cus=" + cus + ", bus_name=" + bus_name + ", to=" + to + ", from="
				+ from + ", arrival_time=" + arrival_time + ", departure_time=" + departure_time + ", ticket_price="
				+ ticket_price + "]";
	}
	//getter setter methods	
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public double getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}
	//overloading constructor with arguments
	public BusSeatBooking(String bus_name,String to, String from, String arrival_time, String departure_time, double ticket_price) {
		super();
		this.bus_name=bus_name;
		this.to = to;
		this.from = from;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_price = ticket_price;
	}
	//bus seat and ticket booking method implementation using threading concept
	public synchronized void seatBookingProcess() {
		add_vechile_infrormation();//method calling to add_vechile_information
		vechile_infrormation_display();//method calling to add_vechile_information display
		String arrival_date;
		String to;
		String from;
		int total_passenger;
		int total_seats=30;
		double total_amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("toatal sets available :"+total_seats);
		System.out.println("enter how many passenger");
		total_passenger=sc.nextInt();
		if(total_seats>=total_passenger) {
			total_seats-=total_passenger;
			int i=0;
			while(i<total_passenger) {
				getcustomer_details();//fetching customer details using customerdetails interface default method
				i+=1;	
			}
			System.out.println("enter To city");
			to=sc.next();
			System.out.println("enter From City");
			from=sc.next();
			System.out.println("enter Arrival date");
			arrival_date=sc.next();
			to.equalsIgnoreCase(to);
			from.equalsIgnoreCase(from);
			Collections.sort(bus_info,new BusByTo());//sorting operation performance using Comparator interface
			BusSeatBooking bus_info1=new BusSeatBooking(null,to,from,null,null,0.0);
			int index=Collections.binarySearch(bus_info,bus_info1,new BusByTo());//Searching operation performance using binarySearch 
			if(index<0)
				System.out.println("bus is not availble");
			else
			{
				//bus Ticket printing
				System.out.println("*****************print Ticket******************");
				System.out.println("bus name            :"+bus_info.get(index).getBus_name());
				System.out.println("customer_deatils        :"+cus.toString());
				System.out.println("City                  :"+bus_info.get(index).getTo()+"  To  "+bus_info.get(index).getFrom());
				System.out.println("number of passengers  :"+total_passenger);
				System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+bus_info.get(index).getArrival_time()+"   depTime   :"+bus_info.get(index).getDeparture_time());
				total_amount=bus_info.get(index).getTicket_price()*total_passenger;
				System.out.println("Toatalticket price    :"+total_amount);
			}
		}
		else
			System.out.println("No seats avalible");		
		}
		//Thread 
		@Override
		public void run() {
			try {
				seatBookingProcess();//method call to seat booking process
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//bus information adding ArrayList abstract method implementation in Transport Info interfaces
		@Override
		public void add_vechile_infrormation() {
			bus_info.add(new BusSeatBooking("Moring Star","hyd","vijaywada","18:00","03:00",1000));
			bus_info.add(new BusSeatBooking("Oranage","hyd","bengulur","20:00","06:00",1500));
			bus_info.add(new BusSeatBooking("Kaveri","Hyd","chennai","18:00","8:00",1600));
		}
		// bus information fetching using for loop and abstract method implementation in Transport Info interfaces
		@Override
		public void vechile_infrormation_display() {
			for(int i=0;i<bus_info.size();i++) {
				System.out.println(""+bus_info.get(i));
			}
		}
	}
	// /sorting operation perform by using comparator
	class BusByTo implements Comparator<BusSeatBooking>{
		@Override
		public int compare(BusSeatBooking o1, BusSeatBooking o2) {
			// TODO Auto-generated method stub
			return o1.to.compareTo(o2.to);
		}
		
	}

