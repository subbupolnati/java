package com.streamapi;

public class Employees {
	int eid;
	String ename;
	int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employees(int eid, String ename, int age) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", ename=" + ename + ", age=" + age + "]";
	}
}
