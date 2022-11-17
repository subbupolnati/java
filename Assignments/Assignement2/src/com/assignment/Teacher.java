package com.assignment;
import java.util.Scanner;
public class Teacher {
	String name;
	int age;
	int numberOfStudents;
	Scanner sc=new Scanner(System.in);
	public Teacher(String name,int age, int numberOfStudents) {
		super();
		this.name = name;
		this.age = age;
		this.numberOfStudents = numberOfStudents;
	}
	public Teacher() {
		super();
		getDetails();
	}
	void getDetails() {
		System.out.println("enter Teacher name: ");
		name=sc.next();
		System.out.println("enter Teacher age: ");
		age=sc.nextInt();
		System.out.println("enter Number of students: ");
		numberOfStudents=sc.nextInt();
	}
	
	  void display() {
		System.out.println("Teacher name: "+name);
		System.out.println("Teacher age: "+age);
		System.out.println("number of students: "+numberOfStudents);
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Teacher t=new Teacher();
		//t.getDetails();
		Teacher p=new Principal("subbu",29,10,"enfec",15);
		//t.display();
		p.display();
	}
}
class Principal extends Teacher{
	String schoolName;
	int numberOfTeachers;
	public Principal(String name,int age, int numberOfStudents,String schoolName, int numberOfTeachers) {
		super(name,age,numberOfStudents);
		this.schoolName=schoolName;
		this.numberOfTeachers = numberOfTeachers;
	}
	public Principal() {
		super();
	}
	void getDetails() {
		System.out.println("enter School name: ");
		schoolName=sc.next();	
		System.out.println("enter Number of Teachers: ");
		numberOfTeachers=sc.nextInt();
	}
	public void setSchool(String schoolName) {
		this.schoolName = schoolName;
	}
	void display() {
		super.display();
		System.out.println("School name: "+schoolName);
		System.out.println("number of teachers: "+numberOfTeachers);
	}
	
}
