package com.comparable;

import java.util.Scanner;
import java.util.TreeSet;

class Employee implements Comparable{
	int eid;
	String ename;
	
	public int getEid() {
		return eid;
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
	

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

	public Employee(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	@Override
	public int compareTo(Object o) {
		Employee e=(Employee)o;
		if(this.eid<e.eid)
			return -1;
		else if(this.eid>e.eid)
				return 1;
		else
			return 0;
		//return this.ename.compareTo(e.ename);
	}
}
public class TreeSetExample {

	public static int eid;
	public static String ename;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter eid:");
		eid=sc.nextInt();
		System.out.println("enter name");
		ename=sc.next();
		
	}
	public static void main(String[] args) {
		
		
		getDetails();
		Employee e=new Employee(eid,ename);
		Employee e1=new Employee(2,"enfec");
		Employee e2=new Employee(1,"gs");
		TreeSet t=new TreeSet();
		t.add(e);
		t.add(e1);
		t.add(e2);
		System.out.println(""+t);
	}

	

}


