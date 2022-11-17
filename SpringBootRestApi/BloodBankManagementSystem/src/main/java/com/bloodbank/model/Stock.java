package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stockid")
	@SequenceGenerator(initialValue = 1,name="stockid",allocationSize = 1)
	private int stockid;
	private String stockblood;
	private String stocktype;
	private String stockdescription;
	private String stocknumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public String getStockblood() {
		return stockblood;
	}
	public void setStockblood(String stockblood) {
		this.stockblood = stockblood;
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
		return "Stock [stockid=" + stockid + ", stockblood=" + stockblood + ", stocktype=" + stocktype
				+ ", stockdescription=" + stockdescription + ", stocknumber=" + stocknumber + "]";
	}
	public Stock(int stockid, String stockblood, String stocktype, String stockdescription, String stocknumber,
			Permission permission) {
		super();
		this.stockid = stockid;
		this.stockblood = stockblood;
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
