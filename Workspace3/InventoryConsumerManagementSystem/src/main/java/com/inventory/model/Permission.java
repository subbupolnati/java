package com.inventory.model;

public class Permission {

	private int permissionid;
	private String permissiontitle;
	private String permissionmodule;
	private String permissiondescription;
	public int getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}
	
	public String getPermissiontitle() {
		return permissiontitle;
	}
	public void setPermissiontitle(String permissiontitle) {
		this.permissiontitle = permissiontitle;
	}
	public String getPermissionmodule() {
		return permissionmodule;
	}
	public void setPermissionmodule(String permissionmodule) {
		this.permissionmodule = permissionmodule;
	}
	public String getPermissiondescription() {
		return permissiondescription;
	}
	public void setPermissiondescription(String permissiondescription) {
		this.permissiondescription = permissiondescription;
	}
	@Override
	public String toString() {
		return "Permission [permissionid=" + permissionid + ", permissiontitle=" + permissiontitle
				+ ", permissionmodule=" + permissionmodule + ", permissiondescription=" + permissiondescription + "]";
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permission(int permissionid, String permissiontitle, String permissionmodule, String permissiondescription) {
		super();
		this.permissionid = permissionid;
		this.permissiontitle = permissiontitle;
		this.permissionmodule = permissionmodule;
		this.permissiondescription = permissiondescription;
	}
}
