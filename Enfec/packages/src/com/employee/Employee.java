package com.employee;
import java.util.Scanner;

import com.employee.manager.Manager;
import com.employee.marketing.MarketingExecutive;
public class Employee {
	 protected int eid;
	 protected String ename;
	 protected int bsal;
	 protected int gross;
	 
	 public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, int bsal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.bsal = bsal;
	}
	public void getDetails() {
		
	}
	public double calcSalary() {
		return bsal;
	}
	public void showDetails() {
		System.out.println("employee id: "+eid);
		System.out.println("employee name: "+ename);
		System.out.println("employee salary: "+bsal);
	}
	

}
