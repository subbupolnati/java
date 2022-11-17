package com.inner;
import java.util.Scanner;

public class TestAnnonymous {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Printable dat=new MyDate() {
			@Override
			public void acceptDetails() {
				
				System.out.println("enter day: ");
				day=sc.nextInt();
				System.out.println("enter month: ");
				mon=sc.nextInt();
				System.out.println("enter year: ");
				year=sc.nextInt();	
				}

				@Override
				public void printDetails() {
					System.out.println("date is: "+day+"-"+mon+"-"+year);
					
				}
		};
		dat.acceptDetails();
		dat.printDetails();
		System.out.println("_________________________");
		Printable emp=new Employee() {
			@Override
			public void acceptDetails() {
				System.out.println("enter employee id: ");
				eid=sc.nextInt();
				System.out.println("enter Employee name: ");
				name=sc.next();
				System.out.println("enter Employee Salary: ");
				sal=sc.nextInt();	
			}
			@Override
			public void printDetails() {
				System.out.println("employee id: "+eid);
				System.out.println("employee name: "+name);
				System.out.println("employee salary: "+sal);
			}
		};
		emp.acceptDetails();
		emp.printDetails();
		System.out.println("_________________________");
		Printable s=new Shape() {
			@Override
			public void acceptDetails() {
				System.out.println("enter Shape");
				name=sc.next();
			}
			void draw() {
				System.out.println("draw a shape :"+name);
			}
			void area() {
				System.out.println("enter radius");
				radius=sc.nextInt();
				System.out.println("area is: "+(3.14*radius*radius));
			}
			@Override
			public void printDetails() {
				draw();
				area();
			}
		};
		s.acceptDetails();
		s.printDetails();
	}	
}
