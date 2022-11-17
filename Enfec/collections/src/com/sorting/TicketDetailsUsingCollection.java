package com.sorting;

import java.util.Scanner;
class Passenger1{
	public String name;
	public String pancard_no;
	public long contact_no;
	public String passport_no;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPancard_no() {
		return pancard_no;
	}
	public void setPancard_no(String pancard_no) {
		this.pancard_no = pancard_no;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public Passenger1(String name, String pancard_no, long contact_no, String passport_no) {
		super();
		this.name = name;
		this.pancard_no = pancard_no;
		this.contact_no = contact_no;
		this.passport_no = passport_no;
	}
	
}
class Plane_Details1 extends Passenger1{
	public int plane_id;
	public String date_of_arrival;
	public String arrival_time;
	public String date_of_departure;
	public String departure_time;
	public String from;
	public String to;
	public double rate_of_ticket;
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public String getDate_of_arrival() {
		return date_of_arrival;
	}
	public void setDate_of_arrival(String date_of_arrival) {
		this.date_of_arrival = date_of_arrival;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDate_of_departure() {
		return date_of_departure;
	}
	public void setDate_of_departure(String date_of_departure) {
		this.date_of_departure = date_of_departure;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getRate_of_ticket() {
		return rate_of_ticket;
	}
	public void setRate_of_ticket(double rate_of_ticket) {
		this.rate_of_ticket = rate_of_ticket;
	}
	public Plane_Details1(String name, String pancard_no, long contact_no, String passport_no, int plane_id,
			String date_of_arrival, String arrival_time, String date_of_departure, String departure_time, String from,
			String to, double rate_of_ticket) {
		super(name, pancard_no, contact_no, passport_no);
		this.plane_id = plane_id;
		this.date_of_arrival = date_of_arrival;
		this.arrival_time = arrival_time;
		this.date_of_departure = date_of_departure;
		this.departure_time = departure_time;
		this.from = from;
		this.to = to;
		this.rate_of_ticket = rate_of_ticket;
	}
}
class Ticket1 extends Plane_Details1{
	public int no_of_seats;
	public int no_of_passenger;
	public double total_amount;
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public int getNo_of_passenger() {
		return no_of_passenger;
	}
	public void setNo_of_passenger(int no_of_passenger) {
		this.no_of_passenger = no_of_passenger;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public Ticket1(String name, String pancard_no, long contact_no, String passport_no, int plane_id,
			String date_of_arrival, String arrival_time, String date_of_departure, String departure_time, String from,
			String to, double rate_of_ticket, int no_of_seats, int no_of_passenger, double total_amount) {
		super(name, pancard_no, contact_no, passport_no, plane_id, date_of_arrival, arrival_time, date_of_departure,
				departure_time, from, to, rate_of_ticket);
		this.no_of_seats = no_of_seats;
		this.no_of_passenger = no_of_passenger;
		this.total_amount = total_amount;
	}
}
public class TicketDetailsUsingCollection {
	public static String name;
	public static String pancard_no;
	public static long contact_no;
	public static String passport_no;
	public static int plane_id;
	public static String date_of_arrival;
	public static String arrival_time;
	public static String departure_time;
	public static String date_of_departure;
	public static String from;
	public static String to;
	public static double rate_of_ticket;
	public static int no_of_seats;
	public static int no_of_passenger;
	public static double total_amount;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter passenger name");
		name=sc.next();
		System.out.println("enter passenger pancard no");
		pancard_no=sc.next();
		System.out.println("enter passenger contact no");
		contact_no=sc.nextLong();
		System.out.println("enter passenger passport number");
		passport_no=sc.next();
		System.out.println("enter plane id");
		plane_id=sc.nextInt();
		System.out.println("enter date_of_arrival");
		date_of_arrival=sc.next();
		System.out.println("enter date_of_departure");
		date_of_departure=sc.next();
		System.out.println("enter arrival_time");
		arrival_time=sc.next();
		System.out.println("enter departure_time");
		departure_time=sc.next();	
		System.out.println("enter from");
		from=sc.next();
		System.out.println("enter to");
		to=sc.next();
		System.out.println("enter rate_of_ticket");
		rate_of_ticket=sc.nextInt();
		System.out.println("enter no of seats");
		no_of_seats=sc.nextInt();
		System.out.println("enter no_of_passenger");
		no_of_passenger=sc.nextInt();
	}
	public static double total_Amount()
	{
		total_amount=rate_of_ticket*no_of_passenger;
		return total_amount;
	}
	public static void ticketPrint() {
		System.out.println("Ticket Details\n name:"+name+"\n plane n:"+plane_id+"\n passport number:"+passport_no+"\n mobile no:"+contact_no);
		System.out.println("From :"+from);
		System.out.println("to   :"+to);
		System.out.println("Arrival date :"+date_of_arrival);
		System.out.println("Arrival time :"+arrival_time);
		System.out.println("Depature date :"+date_of_departure);
		System.out.println("Depature time :"+departure_time);
		System.out.println("List of passengers :"+no_of_passenger);
		System.out.println("Total Amount :"+total_Amount());
	
	}
	public static void main(String[] args) {
		
		getDetails();
		Passenger1 ti=new Ticket1(name,pancard_no,contact_no,passport_no,plane_id,date_of_arrival,arrival_time,date_of_departure,departure_time,from,to,rate_of_ticket,no_of_seats,no_of_passenger,total_amount);
		ticketPrint();
		
		
	}

}
