package com.Assign;

public class TestMain {

	public static void main(String[] args) {
		Printable d=new Date();
		d.acceptDetails();
		d.printDetails();
		System.out.println("____________________");
		Printable e=new Employee();
		e.acceptDetails();
		e.printDetails();
		System.out.println("__________________");
		Printable s=new Shape();
		s.acceptDetails();
		s.printDetails();
		
		

	}

}
