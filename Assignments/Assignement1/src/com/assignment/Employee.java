package com.assignment;

class Mydate{
	int date;
	int mon;
	int year;
	public Mydate(int date, int mon, int year) {
		super();
		this.date = date;
		this.mon = mon;
		this.year = year;
	}
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
}
public class Employee {
	int empid;
	String ename;
	int salary;
	Mydate joiningdate;
	Mydate birth_date;
	
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
	public Mydate getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Mydate joiningdate) {
		this.joiningdate = joiningdate;
	}
	public Mydate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Mydate birth_date) {
		this.birth_date = birth_date;
	}
	public Employee(int empid, String ename, int salary, Mydate joiningdate, Mydate birth_date) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.birth_date = birth_date;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mydate jod=new Mydate(16,11,2021);
		Mydate bod=new Mydate(25,06,1995);
		Employee e=new Employee(1,"subbu",10000,jod,bod);
		System.out.println("Employee id "+e.getEmpid());
		System.out.println("Employee name "+e.getEname());
		System.out.println("Employee salary "+e.getSalary());
		System.out.println("Employee joining date "+e.getJoiningdate().getDate()+"-"+e.getJoiningdate().getMon()+"-"+e.getJoiningdate().getYear());
		System.out.println("Employee date of birth "+e.getBirth_date().getDate()+"-"+e.getBirth_date().getMon()+"-"+e.getBirth_date().getYear());
	}

}
