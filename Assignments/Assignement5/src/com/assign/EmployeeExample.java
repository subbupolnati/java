package com.assign;

import java.util.*;

class Employee{
	int eid;
	String ename;
	double salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(int eid, String ename, double salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
}
class EmpComparatorByEid implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.eid<o2.eid)
			return -1;
		else if(o1.eid>o2.eid)
			return 1;
		else
			return 0;
	}
	
}
class EmpComparatorByEsal implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.salary<o2.salary)
			return -1;
		else if(o1.salary>o2.salary)
			return 1;
		else
			return 0;
	}
	
}
class EmpComparatorByEname implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.ename.compareTo(o2.ename);
	}
	
}
public class EmployeeExample {
	public static int eid;
	public static String ename;
	public static double salary;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter emp id");
		eid=sc.nextInt();
		System.out.println("enter emp name");
		ename=sc.next();
		System.out.println("enter emp salary");
		salary=sc.nextDouble();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList a=new ArrayList();
		EmpComparatorByEname empname=new EmpComparatorByEname();
		EmpComparatorByEid empid=new EmpComparatorByEid();
		EmpComparatorByEsal esal=new EmpComparatorByEsal();
		System.out.println("how many employes details are entered");
		int n=sc.nextInt();
		int i=1;
		while(i<=n) {
			getDetails();
			a.add(new Employee(eid,ename,salary));
			i++;
		}
		Collections.sort(a,empid);
		System.out.println("default sorting in id sorting\n: "+a);
		char ch;
		do {
			System.out.println("enter sorting options:\n 1.Sort by ename \n 2.sort by eid\n 3.sort by salary");
			int option=sc.nextInt();
			switch(option)
			{
			case 1: System.out.println("before sorting\n:"+a);
					Collections.sort(a,empname);
					System.out.println("after sorting\n: "+a);
					break;
			case 2: System.out.println("before sorting\n:"+a);
					Collections.sort(a,empid);
					System.out.println("after sorting\n: "+a);
					break;
			case 3: System.out.println("before sorting\n:"+a);
					Collections.sort(a,esal);
					System.out.println("after sorting\n: "+a);
					break;
			default:
					System.out.println("please select vaild option");
					break;
			}
			System.out.println(" Do u want continue y/n");
			ch=sc.next().charAt(0);
			if(ch=='n')
				break;
		}while(ch=='y');
		
	}
}
