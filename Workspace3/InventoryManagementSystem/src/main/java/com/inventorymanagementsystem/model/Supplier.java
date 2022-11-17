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
@Table(name="supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "supplierid")
	@SequenceGenerator(initialValue = 1,name="supplierid",allocationSize = 1)
	private int supplierid;
	private String suppliername;
	private String suppliermobile;
	private String supplieremail;
	private String supplieraddress;
	private String supplierusername;
	private String supplierpassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSuppliermobile() {
		return suppliermobile;
	}
	public void setSuppliermobile(String suppliermobile) {
		this.suppliermobile = suppliermobile;
	}
	public String getSupplieremail() {
		return supplieremail;
	}
	public void setSupplieremail(String supplieremail) {
		this.supplieremail = supplieremail;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public String getSupplierusername() {
		return supplierusername;
	}
	public void setSupplierusername(String supplierusername) {
		this.supplierusername = supplierusername;
	}
	public String getSupplierpassword() {
		return supplierpassword;
	}
	public void setSupplierpassword(String supplierpassword) {
		this.supplierpassword = supplierpassword;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int supplierid, String suppliername, String suppliermobile, String supplieremail,
			String supplieraddress, String supplierusername, String supplierpassword, Permission permission) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.suppliermobile = suppliermobile;
		this.supplieremail = supplieremail;
		this.supplieraddress = supplieraddress;
		this.supplierusername = supplierusername;
		this.supplierpassword = supplierpassword;
		this.permission = permission;
	}
	
}
