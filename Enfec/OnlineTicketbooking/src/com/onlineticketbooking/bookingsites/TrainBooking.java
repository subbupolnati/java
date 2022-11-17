package com.onlineticketbooking.bookingsites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.onlineticketbooking.customer.Customer;

public class TrainBooking implements Runnable {
	Customer cust;
	ArrayList<TrainBooking> t=new ArrayList<TrainBooking>();
	@Override
	public String toString() {
		return "TrainBooking [train_no=" + train_no + ", train_name=" + train_name + ", to=" + to + ", from=" + from
				+ ", arrival_time=" + arrival_time + ", departure_time=" + departure_time + ", ticket_price="
				+ ticket_price + ", days_of_travaling=" + days_of_travaling + "]";
	}

	public TrainBooking(Customer cust) {
		super();
		this.cust = cust;
	}
	public long train_no;
	public String train_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
	public int days_of_travaling;
	
	public long getTrain_no() {
		return train_no;
	}

	public void setTrain_no(long train_no) {
		this.train_no = train_no;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		train_name = train_name;
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
	public int getDays_of_travaling() {
		return days_of_travaling;
	}

	public void setDays_of_travaling(int days_of_travaling) {
		this.days_of_travaling = days_of_travaling;
	}

	public TrainBooking(long train_no,String train_name, String to, String from, String arrival_time, String departure_time,double ticket_price,int days_of_travaling) {
		super();
		this.train_no=train_no;
		this.train_name = train_name;
		this.to = to;
		this.from = from;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_price = ticket_price;
		this.days_of_travaling=days_of_travaling;
	}
	
	void Train_details() {
		t.add(new TrainBooking(12723,"Andhra Pradesh Express","hyd","delhi","06:25","09:05",1000,2));
		t.add(new TrainBooking(13005,"Amritsar Mail","howrah","amritsar","19:10","08:55",2000,3));
		t.add(new TrainBooking(13105,"Viskha","viskha","hyd","19:00","08:55",500,1));	
		}
	void display() {
		for(int i=0;i<t.size();i++) {
			System.out.println(""+t.get(i));
		}
		
	}
	public synchronized void getDetials() {
		Train_details();
		display();
		String arrival_date;
		String to;
		String from;
		String cotch;
		int total_passenger;
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
		System.out.println("enter cotch ");
		cotch=sc.next();
		to.equalsIgnoreCase(to);
		from.equalsIgnoreCase(from); 
		Collections.sort(t,new TrainByTo());
		TrainBooking tr1=new TrainBooking(0,null,to,from,null,null,0.0,0);
		int index=Collections.binarySearch(t,tr1,new TrainByTo());
		
		if(index<0)
			System.out.println("Train is not availble");
		else 
		{
			System.out.println("*****************print Ticket******************");
			System.out.println("Trainname             :"+t.get(index).getTrain_name());
			System.out.println("Tain number           :"+t.get(index).getTrain_no());;
			System.out.println("customer_name         :"+cust.customerName);
			System.out.println("customer_mobile no    :"+cust.mobileno);
			System.out.println("City                  :"+t.get(index).getTo()+"  To  "+t.get(index).getFrom());
			System.out.println("cotch                 :"+cotch);
			System.out.println("number of passengers  :"+total_passenger);
			System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+t.get(index).getArrival_time()+"   depTime   :"+t.get(index).getDeparture_time());
			total_amount=t.get(index).getTicket_price()*total_passenger;
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
class TrainByTo implements Comparator<TrainBooking>{

	@Override
	public int compare(TrainBooking o1, TrainBooking o2) {
		return o1.to.compareTo(o2.to);
	}

}
