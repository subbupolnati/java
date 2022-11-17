package com.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class Employee1 implements Comparable{
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

	public Employee1(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	@Override
	public int compareTo(Object o) {
		Employee1 e=(Employee1)o;
		if(this.eid<e.eid)
			return -1;
		else if(this.eid>e.eid)
				return 1;
		else
			return 0;
		//return this.ename.compareTo(e.ename);
	}
}
public class ArrayListExample {

	public static void main(String[] args) {
		Employee1 e=new Employee1(10,"subbu");
		Employee1 e1=new Employee1(2,"enfec");
		Employee1 e2=new Employee1(15,"gs");
		ArrayList t=new ArrayList();
		t.add(e);
		t.add(e1);
		t.add(e2);
		System.out.println(""+t);
		Collections.sort(t);
		System.out.println(""+t);

	}

}
