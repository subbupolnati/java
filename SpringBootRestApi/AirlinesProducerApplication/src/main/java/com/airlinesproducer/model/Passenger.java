package com.airlinesproducer.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.airlinesproducer.service.PassengerService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//This passenger class used store and retrieve passenger data
@Entity
@Table(name="passenger")//table create
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "passenger_id")
	@SequenceGenerator(initialValue = 1,name="passenger_id",allocationSize = 1)
	private int passenger_id;//This field will store passenger_id
	private String name;//This field will store passenger name
	private String trips;//This field will store trips
	@ManyToOne(fetch = FetchType.EAGER)//many to associtiaon relationship
	@JoinColumn(name="Airline")
	//@JsonBackReference
	//@JsonIgnore
	//@JsonManagedReference
	private Airlines airline;//Has type relationship
	
	//Getter and setter methods
	
	public Passenger(PassengerService passengerService) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
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
	public Passenger(int passenger_id, String name, String trips, Airlines airline) {
		super();
		this.passenger_id = passenger_id;
		this.name = name;
		this.trips = trips;
		this.airline = airline;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
