package com.seat_booking_customers;
//create a customer class
public class Customer {
	//declare variables
	public String customerName;
	public long mobileno;
	public String address;
	public int seat_no;
	//getter and setter methods
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
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
	//toString method implementation
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", mobileno=" + mobileno + ", address=" + address
				+ ", seat_no=" + seat_no + "]";
	}
	//Customer class constructor creation
	public Customer(String customerName, long mobileno, String address,int seat_no) {
		super();
		this.customerName = customerName;
		this.mobileno = mobileno;
		this.address = address;
		this.seat_no=seat_no;
	}
}
