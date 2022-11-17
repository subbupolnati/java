package com.example;

import javax.validation.constraints.Min;
//This is a Employee class
public class Employee {
	@Min(value = 2000,message = "Should be greater than 2000")
	int eid;
	String ename;
	@Min(value = 45000,message = "Should be greater than 45000")
	int salary;
	
	@OneToOne()
	public int getEid() {
		return eid;
	}
	public Employee(int eid, String ename, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	public Employee() {
		super();
		//TODO Auto-generated constructor stub
	}
	public void setEid(int eid) {
		this.eid = eid;
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
}

