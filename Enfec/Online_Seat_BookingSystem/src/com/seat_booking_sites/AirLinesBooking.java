package com.seat_booking_sites;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import com.seat_booking_customers.Customer;
import com.seat_booking_customers.Customerdetails;
public class AirLinesBooking implements Runnable,Customerdetails,Transport_Info{
	Customer cust;//customer module inherit the has-A type relation
	ArrayList<AirLinesBooking> airline=new ArrayList<AirLinesBooking>();
	//Declare variables
	public String plane_name;
	public String to;
	public String from;
	public String arrival_time;
	public String departure_time;
	public double ticket_price;
	//AirlinesBooking constructor
	public AirLinesBooking() {
		super();
	}
	//to string methods
	@Override
	public String toString() {
		return "AirLinesBooking [cust=" + cust + ", cus=" + cus + ", plane_name=" + plane_name + ", to=" + to
				+ ", from=" + from + ", arrival_time=" + arrival_time + ", departure_time=" + departure_time
				+ ", ticket_price=" + ticket_price + "]";
	}
	
	//airlines booking argument constructor
	public AirLinesBooking(String plane_name, String to, String from, String arrival_time, String departure_time,
			double ticket_price) {
		super();
		this.plane_name = plane_name;
		this.to = to;
		this.from = from;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_price = ticket_price;
	}
	//getter setter methods
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
	//seat booking method implementation using synchronized thread safe operations
	public synchronized void seatBookingProcess() {
		add_vechile_infrormation();//calling method to fetch flight details
		vechile_infrormation_display();//display the one by one flight details
		String arrival_date;
		String to;
		String from;
		int total_passenger;
		int total_seats=50;
		double total_amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("toatal sets available :"+total_seats);
		System.out.println("enter how many passenger");
		total_passenger=sc.nextInt();
		if(total_seats>=total_passenger) {
			total_seats-=total_passenger;//seats value modification
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
			Collections.sort(airline,new AirLinesByFromName());//sorting in  flight names using AirlinesByFromName class calling implements Comparator
			AirLinesBooking airline1=new AirLinesBooking(null,to,from,null,null,0.0);
			int index=Collections.binarySearch(airline,airline1,new AirLinesByFromName());//Searching for flight names using AirlinesByFromName class calling implements Comparator
			if(index<0)
				System.out.println("palne is not availble");
			else
			{	//Airlines ticket printing
				System.out.println("*****************print Ticket******************");
				System.out.println("plane name            :"+airline.get(index).getPlane_name());
				System.out.println("customer_deatils        :"+cus.toString());
				System.out.println("City                  :"+airline.get(index).getTo()+"  To  "+airline.get(index).getFrom());
				System.out.println("number of passengers  :"+total_passenger);
				System.out.println("Date and time      	  :"+arrival_date+"  Time  :"+airline.get(index).getArrival_time()+"   depTime   :"+airline.get(index).getDeparture_time());
				total_amount=airline.get(index).getTicket_price()*total_passenger;
				System.out.println("Toatalticket price    :"+total_amount);
			}
		}
		else {
			System.out.println("Seats are not available");
		}	
	}
	@Override
	//using thread concept 
	public void run() {
		try {
			seatBookingProcess();//flight and customer travel details method calling
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// exception handling
			e.printStackTrace();
		}
	}		
	//flight details retrieve using for loop abstract method in implementation in Transport Info interfaces 
	@Override
	public void vechile_infrormation_display() {
		for(int i=0;i<airline.size();i++) {
			System.out.println(""+airline.get(i));
		}
		
	}
	//Predefined flight details abstract method implementation in Transport Info interfaces 
	@Override
	public void add_vechile_infrormation() {
		airline.add(new AirLinesBooking("airjet","Hyd","delhi","18:00","03:00",5000));
		airline.add(new AirLinesBooking("Kingfisher","Hyd","mumbai","14:00","20:00",15000));
		airline.add(new AirLinesBooking("UAE Airlines","Hyd","dubai","11:00","15:00",20000));
		airline.add(new AirLinesBooking("United AirLines","Hyd","Us","20:00","09:00",26000));
		airline.add(new AirLinesBooking("airjet","Hyd","chennai","18:00","1:00",9000));
		
	}
}
//sorting perform using airplane name by comparator class creating
class AirLinesByFromName implements Comparator<AirLinesBooking>{

	@Override
	public int compare(AirLinesBooking o1, AirLinesBooking o2) {
		
		return o1.from.compareToIgnoreCase(o2.from);
	}
	
}