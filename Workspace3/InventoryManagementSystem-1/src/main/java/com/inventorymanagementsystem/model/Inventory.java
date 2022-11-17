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
@Table(name="inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "inventoryid")
	@SequenceGenerator(initialValue = 1,name="inventoryid",allocationSize = 1)
	private int inventoryid;
	private String invventorydescription;
	private String inventorynumber;
	private String inventorytype;
	private String inventoryitems;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getInventoryid() {
		return inventoryid;
	}
	public void setInventoryid(int inventoryid) {
		this.inventoryid = inventoryid;
	}
	public String getInvventorydescription() {
		return invventorydescription;
	}
	public void setInvventorydescription(String invventorydescription) {
		this.invventorydescription = invventorydescription;
	}
	public String getInventorynumber() {
		return inventorynumber;
	}
	public void setInventorynumber(String inventorynumber) {
		this.inventorynumber = inventorynumber;
	}
	public String getInventorytype() {
		return inventorytype;
	}
	public void setInventorytype(String inventorytype) {
		this.inventorytype = inventorytype;
	}
	public String getInventoryitems() {
		return inventoryitems;
	}
	public void setInventoryitems(String inventoryitems) {
		this.inventoryitems = inventoryitems;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Inventory(int inventoryid, String invventorydescription, String inventorynumber, String inventorytype,
			String inventoryitems, Permission permission) {
		super();
		this.inventoryid = inventoryid;
		this.invventorydescription = invventorydescription;
		this.inventorynumber = inventorynumber;
		this.inventorytype = inventorytype;
		this.inventoryitems = inventoryitems;
		this.permission = permission;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
