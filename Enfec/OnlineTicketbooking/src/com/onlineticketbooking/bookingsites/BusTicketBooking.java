package com.onlineticketbooking.bookingsites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.onlineticketbooking.customer.Customer;

public class BusTicketBooking implements Runnable {
	Customer cust;
	ArrayList<BusTicketBooking> bt=new ArrayList<BusTicketBooking>();
	public BusTicketBooking(Customer cust) {
		super();
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "BusTicketBooking [bus_name=" + bus_name + ", to=" + to + ", from=" + from + ", arrival_time="
				+ arrival_time + ", departure_time=" + departure_time + ", ticket_price=" + ticket_price + "]";
	}
	public String bus_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
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
	public BusTicketBooking(String bus_name,String to, String from, String arrival_time, String departure_time, double ticket_price) {
		super();
		this.bus_name=bus_name;
		this.to = to;
		this.from = from;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_price = ticket_price;
	}
	void bus_details() {
		bt.add(new BusTicketBooking("Moring Star","hyd","vijaywada","18:00","03:00",1000));
		bt.add(new BusTicketBooking("Oranage","hyd","bengulur","20:00","06:00",1500));
		bt.add(new BusTicketBooking("Kaveri","Hyd","chennai","18:00","8:00",1600));
	}
	void display() {
		for(int i=0;i<bt.size();i++) {
			System.out.println(""+bt.get(i));
		}
		
	}
	public synchronized void getDetials() {
		bus_details();
		display();
		String arrival_date;
		String to;
		String from;
		int total_passenger;
		int total_seats=30;
		double total_amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter To city");
		to=sc.next();
		System.out.println("enter From City");
		from=sc.next();
		System.out.println("enter how many passenger");
		total_passenger=sc.nextInt();
		System.out.println("enter Arrival date");
		arrival_date=sc.next();
		to.equalsIgnoreCase(to);
		from.equalsIgnoreCase(from);
		Collections.sort(bt,new BusByTo());
		BusTicketBooking tr=new BusTicketBooking(null,to,from,null,null,0.0);
		int index=Collections.binarySearch(bt,tr,new BusByTo());
		
		if(index<0)
			System.out.println("bus is not availble");
		else
		{
			if(total_seats>=total_passenger) {
				total_seats-=total_passenger;
				System.out.println("*****************print Ticket******************");
				System.out.println("bus name            :"+bt.get(index).getBus_name());
				System.out.println("customer_name         :"+cust.customerName);
				System.out.println("customer_mobile no    :"+cust.mobileno);
				System.out.println("City                  :"+bt.get(index).getTo()+"  To  "+bt.get(index).getFrom());
				System.out.println("number of passengers  :"+total_passenger);
				System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+bt.get(index).getArrival_time()+"   depTime   :"+bt.get(index).getDeparture_time());
				total_amount=bt.get(index).getTicket_price()*total_passenger;
				System.out.println("Toatalticket price    :"+total_amount);
			}
			else
				System.out.println("No seats avalible");
		}
		
	}
	@Override
	public void run() {
		try {
			getDetials();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
class BusByTo implements Comparator<BusTicketBooking>{

	@Override
	public int compare(BusTicketBooking o1, BusTicketBooking o2) {
		// TODO Auto-generated method stub
		return o1.to.compareTo(o2.to);
	}
	
}