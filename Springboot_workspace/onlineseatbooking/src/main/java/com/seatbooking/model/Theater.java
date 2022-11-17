package com.seatbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Theater {
	@Id
	private int theaterid;
	@Column
	private String theatername;
	@Column
	private String moviename;
	@Column 
	private String location;
	@Column 
	private int price;
	public int getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(int theaterid) {
		this.theaterid = theaterid;
	}
	public String getTheatername() {
		return theatername;
	}
	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
