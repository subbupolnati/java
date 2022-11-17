package com.print;

public class Employee implements Printable {
	int emp_id;
	String emp_name;
	int basic;
	
	public Employee(int emp_id, String emp_name, int basic) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.basic = basic;
	}

	@Override
	public void printData() {
		System.out.println("print Employee Details");
		System.out.println("print Employee id="+emp_id);
		System.out.println("print Employee name="+emp_name);
		System.out.println("print Employee salary="+basic);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable p=new Employee(101,"subbu",10000);
		p.printData();
		System.out.println("________________________");
		Printable s=new Shape("circle");
		System.out.println("_____________________");
		Printable date=new MyDate(10,12,2021);
		date.printData();
		
		
	}

}
