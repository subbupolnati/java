package com.aadhar.model;

public class Aadhar {

	private String aadharNumber;
	private String name;
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Aadhar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aadhar(String aadharNumber, String name) {
		super();
		this.aadharNumber = aadharNumber;
		this.name = name;
	}
	
}
