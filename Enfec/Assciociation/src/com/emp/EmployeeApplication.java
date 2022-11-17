package com.emp;
class Mydate
{
	int date;
	int mon;
	int year;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Mydate(int date, int mon, int year) {
		super();
		this.date = date;
		this.mon = mon;
		this.year = year;
	}
	
}
class Employee
{
	int empid;
	String ename;
	int Salary;
	Mydate joiningdate;//Association or HAS-A type of relationship between employee and date Object
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
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public Mydate getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Mydate joiningdate) {
		this.joiningdate = joiningdate;
	}
	public Employee(int empid, String ename, int salary, Mydate joiningdate) {
		super();
		this.empid = empid;
		this.ename = ename;
		Salary = salary;
		this.joiningdate = joiningdate;
	}

}
public class EmployeeApplication {

	public static void main(String[] args) {
		int day=10;
		int mon=2;
		int year=2001;
		int eid=1001;
		String ename="subbu";
		int salary=10000;
		Mydate d=new Mydate(day,mon,year);
		Employee e=new Employee(eid,ename,salary,d);
		System.out.println("EmployeeId= "+e.getEmpid());
		System.out.println("Employeename= "+e.getEname());
		System.out.println("Employee Salary= "+e.getSalary());
		System.out.println("Doj= "+e.getJoiningdate().getDate()+"-"+e.getJoiningdate().getMon()+"-"+e.getJoiningdate().getYear());
		
	}

}
