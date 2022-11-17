package com.inventory.model;


public class Payment {

	private int paymentid;
	private int customerid;
	private String paymentamount;
	private String paymentdescription;
	private Permission permission;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(String paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getPaymentdescription() {
		return paymentdescription;
	}
	public void setPaymentdescription(String paymentdescription) {
		this.paymentdescription = paymentdescription;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Payment(int paymentid, int customerid, String paymentamount, String paymentdescription,
			Permission permission) {
		super();
		this.paymentid = paymentid;
		this.customerid = customerid;
		this.paymentamount = paymentamount;
		this.paymentdescription = paymentdescription;
		this.permission = permission;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
