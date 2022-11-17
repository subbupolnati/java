package com.airlines.model;

import java.util.Arrays;

public class Passenger {

	private int passenger_id;
	private String name;
	private String trips;
	private Airlines airline;
	
	
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrips() {
		return trips;
	}
	public void setTrips(String trips) {
		this.trips = trips;
	}
	public Airlines getAirline() {
		return airline;
	}
	public void setAirline(Airlines airline) {
		this.airline = airline;
	}
	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", name=" + name + ", trips=" + trips + ", airline="
				+ airline + "]";
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
