package com.booking.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketBooking {

	@Id
	private int ticketId;
	private int busId;
	private Date date;
	private int passengers;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
}
