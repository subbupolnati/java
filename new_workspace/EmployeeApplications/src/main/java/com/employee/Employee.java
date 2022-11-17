package com.employee;

import java.util.Date;

public class Employee {
	private int empid;
	private String ename;
	private int salary;
	private Date doj;
	private String address;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj2) {
		this.doj = doj2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
