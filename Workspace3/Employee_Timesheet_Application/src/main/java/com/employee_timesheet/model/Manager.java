package com.employee_timesheet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {

	@Id
	@GeneratedValue
	private int managerId;
	private String managerMail;
	private String uid;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerMail() {
		return managerMail;
	}
	public void setManagerMail(String managerMail) {
		this.managerMail = managerMail;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerMail=" + managerMail + ", uid=" + uid + "]";
	}
	public Manager(int managerId, String managerMail, String uid) {
		super();
		this.managerId = managerId;
		this.managerMail = managerMail;
		this.uid = uid;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
