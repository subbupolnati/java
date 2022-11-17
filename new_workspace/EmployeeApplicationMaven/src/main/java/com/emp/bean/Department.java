package com.emp.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;
@Component("dept")
public class Department{
	@Value("10")
	int dept_id;
	@Value("IT")
	String dept_name;
	@Value("Hyd")
	String dept_location;
	@Autowired
	Employee employee;
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_location() {
		return dept_location;
	}
	public void setDept_location(String dept_location) {
		this.dept_location = dept_location;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
