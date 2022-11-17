package com.Assign;
import java.util.Scanner;
public class Employee implements Printable {
	int emp_id;
	String emp_name;
	int basic;
	Scanner sc=new Scanner(System.in);
	public Employee(int emp_id, String emp_name, int basic) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.basic = basic;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void acceptDetails() {
		System.out.println("enter Employee id");
		emp_id=sc.nextInt();
		System.out.println("enter Employee emp_name");
		emp_name=sc.next();
		System.out.println("enter Employee salary");
		basic =sc.nextInt();
	}

	@Override
	public void printDetails() {
		System.out.println("print Employee Details");
		System.out.println("print Employee id="+emp_id);
		System.out.println("print Employee name="+emp_name);
		System.out.println("print Employee salary="+basic);
		
	}

}
