package com.employee;
public class Employee1{
	//declare variable
	 protected int eid;
	 protected String ename;
	 protected int bsal;
	 protected int gross;
	 protected int net;
	 //argument constructor
	 public Employee1(int eid,String ename,int bsal){
		 super();
		 this.eid=eid;
		 this.ename=ename;
		 this.bsal=bsal;
		 this.gross=10000;
		 this.net=net;
	 }
	//no argument constructor
	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Calculate salary 
	public int calculateSalary() {
		gross=10000;
		return gross;
	}
	//show employee details
	public void showDetails() {
		System.out.println("empid: "+eid);
		System.out.println("ename: "+ename);
		System.out.println("basic salary: "+bsal);
	}
}
