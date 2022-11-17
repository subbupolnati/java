package com.seat_booking_sites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.seat_booking_customers.Customer;
import com.seat_booking_customers.Customerdetails;
//create a class train booking and implements runnable and Customerdetails,Transport_Info
public class TrainBooking implements Customerdetails,Transport_Info,Runnable{
	Customer cust;//customer module inherit the has-A type relation
	ArrayList<TrainBooking> train=new ArrayList<TrainBooking>();
	//Declare variables
	public long train_no;
	public String train_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
	public int days_of_travaling;
	@Override
	//toString method implementation
	public String toString() {
		return "TrainBooking [cust=" + cust + ", cus=" + cus + ", train_no=" + train_no + ", train_name=" + train_name
				+ ", to=" + to + ", from=" + from + ", arrival_time=" + arrival_time + ", departure_time="
				+ departure_time + ", ticket_price=" + ticket_price + ", days_of_travaling=" + days_of_travaling + "]";
	}
	//create a no-argument constructor
	public TrainBooking() {
		super();
	}
	//getter setter methods
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
	//create another constructor using parameters
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
	//seat booking method implementation using synchronized thread safe operations
	public synchronized void seatBookingProcess() {
		add_vechile_infrormation();//method calling to add_vechile_information
		vechile_infrormation_display();//method calling to vechile information display 
		String arrival_date;
		String to;
		String from;
		String cotch;
		int total_seats=60;
		int total_passenger;
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
			System.out.println("enter cotch ");
			cotch=sc.next();
			to.equalsIgnoreCase(to);
			from.equalsIgnoreCase(from); 
			Collections.sort(train,new TrainByTo());//sorting in  to place using trainByTo class calling implements Comparator
			TrainBooking train1=new TrainBooking(0,null,to,from,null,null,0.0,0);
			int index=Collections.binarySearch(train,train1,new TrainByTo());//searching operation perform 
			if(index<0)
				System.out.println("Train is not availble");
			else 
			{	//Train ticket printing
				System.out.println("*****************print Ticket******************");
				System.out.println("Trainname             :"+train.get(index).getTrain_name());
				System.out.println("Tain number           :"+train.get(index).getTrain_no());;
				System.out.println("customer_deatils        :"+cus.toString());
				System.out.println("City                  :"+train.get(index).getTo()+"  To  "+train.get(index).getFrom());
				System.out.println("cotch                 :"+cotch);
				System.out.println("number of passengers  :"+total_passenger);
				System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+train.get(index).getArrival_time()+"   depTime   :"+train.get(index).getDeparture_time());
				total_amount=train.get(index).getTicket_price()*total_passenger;
				System.out.println("Toatalticket price    :"+total_amount);	
			}
		}
		else
			System.out.println("No seats are avalible");
	}
	//using Thread 
	@Override
	public void run() {
		try {
			seatBookingProcess();//method call to seat booking process
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//trains information add to ArrayList abstract method implementation in Transport Info interfaces 
	@Override
	public void add_vechile_infrormation() {
		train.add(new TrainBooking(12723,"Andhra Pradesh Express","hyd","delhi","06:25","09:05",1000,2));
		train.add(new TrainBooking(13005,"Amritsar Mail","howrah","amritsar","19:10","08:55",2000,3));
		train.add(new TrainBooking(13105,"Viskha","viskha","hyd","19:00","08:55",500,1));		
	}
	//trains information fetching using for loop and abstract method implementation in Transport Info interfaces  
	@Override
	public void vechile_infrormation_display() {
		for(int i=0;i<train.size();i++) {
			System.out.println(""+train.get(i));
		}	
	}
}
//sorting operation perform by using comparator
class TrainByTo implements Comparator<TrainBooking>{
	@Override
	public int compare(TrainBooking o1, TrainBooking o2) {
		return o1.to.compareTo(o2.to);
	}

}

