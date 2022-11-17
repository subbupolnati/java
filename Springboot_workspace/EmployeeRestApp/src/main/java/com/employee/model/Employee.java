package com.employee.model;

import java.util.Scanner;

public class Employee {
	int empid;
	String ename;
	int salary;
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ","
				+ " ename=" + ename + ","
				+ " salary=" + salary + "]";
	}
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
	public Employee(int empid, String ename, int salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
