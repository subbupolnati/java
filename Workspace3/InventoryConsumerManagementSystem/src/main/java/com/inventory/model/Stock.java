package com.inventory.model;

public class Stock {

	
	private int stockid;
	private String stockitems;
	private String stocktype;
	private String stockdescription;
	private String stocknumber;
	private Permission permission;
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	
	public String getStockitems() {
		return stockitems;
	}
	public void setStockitems(String stockitems) {
		this.stockitems = stockitems;
	}
	public String getStocktype() {
		return stocktype;
	}
	public void setStocktype(String stocktype) {
		this.stocktype = stocktype;
	}
	public String getStockdescription() {
		return stockdescription;
	}
	public void setStockdescription(String stockdescription) {
		this.stockdescription = stockdescription;
	}
	public String getStocknumber() {
		return stocknumber;
	}
	public void setStocknumber(String stocknumber) {
		this.stocknumber = stocknumber;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", stockitems=" + stockitems + ", stocktype=" + stocktype
				+ ", stockdescription=" + stockdescription + ", stocknumber=" + stocknumber + "]";
	}
	public Stock(int stockid, String stockitems, String stocktype, String stockdescription, String stocknumber,
			Permission permission) {
		super();
		this.stockid = stockid;
		this.stockitems = stockitems;
		this.stocktype = stocktype;
		this.stockdescription = stockdescription;
		this.stocknumber = stocknumber;
		this.permission = permission;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
