package com.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venue")
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)      
	private int venueid;
	private String venueName;
	private String venueAddress;
	private String city;
	private String state;
	private String zipcode;
	public int getVenueid() {
		return venueid;
	}
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Venue [venueName=" + venueName + ", venueAddress=" + venueAddress + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venue(int venueid, String venueName, String venueAddress, String city, String state, String zipcode) {
		super();
		this.venueid = venueid;
		this.venueName = venueName;
		this.venueAddress = venueAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
}
