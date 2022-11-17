package com.onlineticketbooking.customer;

public class Customer {
	public int customerID;
	public String customerName;
	public long mobileno;
	public String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", mobileno=" + mobileno
				+ ", address=" + address + "]";
	}
	public Customer(int customerID, String customerName, long mobileno, String address) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.mobileno = mobileno;
		this.address = address;
	}
}
