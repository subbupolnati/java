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
@Table(name="order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderid")
	@SequenceGenerator(initialValue = 1,name="orderid",allocationSize = 1)
	private int orderid;
	private String bloodgroup;
	private String ordertype;
	private String orderdescription;
	@OneToOne(cascade = CascadeType.ALL)
	private Patient patient;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrderdescription() {
		return orderdescription;
	}
	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}
	
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", bloodgroup=" + bloodgroup + ", ordertype=" + ordertype
				+ ", orderdescription=" + orderdescription + ", patient=" + patient + "]";
	}
	public Order(int orderid, String bloodgroup, String ordertype, String orderdescription, Patient patient,
			Permission permission) {
		super();
		this.orderid = orderid;
		this.bloodgroup = bloodgroup;
		this.ordertype = ordertype;
		this.orderdescription = orderdescription;
		this.patient = patient;
		this.permission = permission;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
