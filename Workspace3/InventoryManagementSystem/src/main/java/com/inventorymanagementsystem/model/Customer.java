package com.inventorymanagementsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerid")
	@SequenceGenerator(initialValue = 1,name="customerid",allocationSize = 1)
	@Id
	private int customerid;
	private String customername;
	private String customermobile;
	private String customeremail;
	private String customerusername;
	private String customerpassword;
	private String customeraddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomermobile() {
		return customermobile;
	}
	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customermobile="
				+ customermobile + ", customeremail=" + customeremail + ", customerusername=" + customerusername
				+ ", customerpassword=" + customerpassword + ", customeraddress=" + customeraddress + "]";
	}
	public Customer(int customerid, String customername, String customermobile, String customeremail,
			String customerusername, String customerpassword, String customeraddress, Permission permission) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customermobile = customermobile;
		this.customeremail = customeremail;
		this.customerusername = customerusername;
		this.customerpassword = customerpassword;
		this.customeraddress = customeraddress;
		this.permission = permission;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
