package com.customer;

public class Customer {
	int cid;
	String cname;
	String address;
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}
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
