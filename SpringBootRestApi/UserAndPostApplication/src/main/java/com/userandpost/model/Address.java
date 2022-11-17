package com.userandpost.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//This Model class encapuslates Address data 
@Entity
@Table(name="address")//Table name
public class Address {
	@Id//Primary key
	private String street;//This field store street details
	private String suite;//This field store suite details
	private String city;//This field store city details
	private String zipcode;//This field store zipcode details
	@OneToOne(cascade = CascadeType.ALL)//establish the one to one relationship
	private Geo geo;//This field store Geo class details
	//Getter and setter methods
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
	

}
