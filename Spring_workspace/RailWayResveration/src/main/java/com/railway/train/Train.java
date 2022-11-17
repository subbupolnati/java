package com.railway.train;

import com.railway.customer.Customer;

public class Train extends Customer{

	private int trainnumber;
	private String tname;
	private String from;
	private String to;
	private String coach;
	private int price;
	public int getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(int trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
