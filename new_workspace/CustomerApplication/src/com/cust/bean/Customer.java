package com.cust.bean;
//customer class	
public class Customer {
	int cid;//customer id
	String cname;//customer name
	String address;//customer address
	//customer to string method
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}
	//getter and setter methods
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
