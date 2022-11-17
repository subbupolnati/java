package com.employee.bean;

public class Employee {
	int empid;
	String ename;
	int salary;
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
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	public void employeeDetails() {
		System.out.println("employee_id"+getEmpid());
		System.out.println("Employee name"+getEname());
		System.out.println("Employee Salary"+getSalary());
	}

}
