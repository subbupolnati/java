package com.comparator;

import java.util.Comparator;
import java.util.TreeSet;

class Employee{
	int eid;
	String ename;
	int salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	public Employee(int eid, String ename, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	
}
class EmpComparatorById implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		if(e1.eid<e2.eid)
			return -1;
		else if(e1.eid>e2.eid)
			return 1;
		else
			return 0;
	}
}
class EmpComparatorByName implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {

		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		return e1.ename.compareTo(e2.ename);
	}
}
class EmpComparatorBySalary implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {

		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		if(e1.salary<e2.salary)
			return -1;
		else if(e1.salary>e2.salary)
			return 1;
		else
			return 0;
	}
}
public class TreeSetExample {

	public static void main(String[] args) {
		EmpComparatorBySalary ed=new EmpComparatorBySalary();
		TreeSet ts=new TreeSet(ed);//Customized Sorting order
		ts.add(new Employee(80,"Mona",900));
		ts.add(new Employee(100,"Sona",400));
		ts.add(new Employee(12,"Komal",78));
		ts.add(new Employee(120,"Monal",800));
		System.out.println(""+ts);	

	}

}
