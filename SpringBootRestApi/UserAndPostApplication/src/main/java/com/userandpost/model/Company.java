package com.userandpost.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//This Model class encapuslates company data 
@Entity
public class Company {

	@Id//primary key
	private String name;//This field store comapny name details
	private String catchPhrase;//This field store company catchPharse details
	private String bs;//This field store company bs details
	//Getter and setter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	
}
