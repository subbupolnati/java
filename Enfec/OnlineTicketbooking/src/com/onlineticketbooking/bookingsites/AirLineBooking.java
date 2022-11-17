package com.onlineticketbooking.bookingsites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.onlineticketbooking.customer.Customer;
public class AirLineBooking implements Runnable{
	Customer cust;
	ArrayList<AirLineBooking> a=new ArrayList<AirLineBooking>();
	public AirLineBooking(Customer cust) {
		super();
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "AirLineBooking [plane_name=" + plane_name + ", to=" + to + ", from=" + from + ", arrival_time="
				+ arrival_time + ", departure_time=" + departure_time + ", ticket_price=" + ticket_price + "]";
	}
	public String plane_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
	
	public AirLineBooking(String plane_name, String to, String from, String arrival_time, String departure_time,
			double ticket_price) {
		super();
		this.plane_name = plane_name;
		this.to = to;
		this.from = from;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_price = ticket_price;
	}
	public String getPlane_name() {
		return plane_name;
	}
	public void setPlane_name(String plane_name) {
		this.plane_name = plane_name;
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
	void display() {
		for(int i=0;i<a.size();i++) {
			System.out.println(""+a.get(i));
		}
		
	}
	void plane_details() {
		a.add(new AirLineBooking("airjet","Hyd","delhi","18:00","03:00",5000));
		a.add(new AirLineBooking("Kingfisher","Hyd","mumbai","14:00","20:00",15000));
		a.add(new AirLineBooking("UAE Airlines","Hyd","dubai","11:00","15:00",20000));
		a.add(new AirLineBooking("United AirLines","Hyd","Us","20:00","09:00",26000));
		a.add(new AirLineBooking("airjet","Hyd","chennai","18:00","1:00",9000));
	}
	public synchronized void getDetials() {
		plane_details();
		display();
		String passport_number;
		String arrival_date;
		String to;
		String from;
		int total_passenger;
		int total_seats=50;
		double total_amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter to passport number");
		passport_number=sc.next();
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
		Collections.sort(a,new AirLineByFromName());
		AirLineBooking ar1=new AirLineBooking(null,to,from,null,null,0.0);
		int index=Collections.binarySearch(a,ar1,new AirLineByFromName());
		if(index<0)
			System.out.println("palne is not availble");
		else
		{
			System.out.println("*****************print Ticket******************");
			System.out.println("plane name            :"+a.get(index).getPlane_name());
			System.out.println("customer passport no  :"+passport_number);
			System.out.println("customer_name         :"+cust.customerName);
			System.out.println("customer_mobile no    :"+cust.mobileno);
			System.out.println("City                  :"+a.get(index).getTo()+"  To  "+a.get(index).getFrom());
			System.out.println("number of passengers  :"+total_passenger);
			System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+a.get(index).getArrival_time()+"   depTime   :"+a.get(index).getDeparture_time());
			total_amount=a.get(index).getTicket_price()*total_passenger;
			System.out.println("Toatalticket price    :"+total_amount);
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
class AirLineByFromName implements Comparator<AirLineBooking>{

	@Override
	public int compare(AirLineBooking o1, AirLineBooking o2) {
		
		return o1.from.compareToIgnoreCase(o2.from);
	}
	
}