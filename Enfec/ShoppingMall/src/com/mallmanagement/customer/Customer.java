package com.mallmanagement.customer;
//customer class creation
public class Customer {
	//Declare variables
	public int customerID;
	public String customerName;
	public long mobileno;
	//setter and getter methods
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	//customer constructor with arguments
	public Customer(int customerID, String customerName, long mobileno) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.mobileno = mobileno;
	}
}
