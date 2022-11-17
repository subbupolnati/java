package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee1")
public class Employee {
	@Id
	private int empid;
	@Size(min=3,message = "Employee name should contains min 3 characters")
	@Column
	private String ename;
	@Column
	private int salary;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	@JsonBackReference
	private Department dept;

	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
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
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", salary=" + salary + ", dept=" + dept + "]";
	}
	public Employee(int empid, @Size(min = 3, message = "Employee name should contains min 3 characters") String ename,
			int salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, @Size(min = 3, message = "Employee name should contains min 3 characters") String ename,
			int salary, Department dept) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
	}
	
}
