package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Student{
		int id;
		String name;
		int marks;
		public Student(int id, String name, int marks) {
			super();
			this.id = id;
			this.name = name;
			this.marks = marks;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
		}
}
public class StudentList {
	public static int id;
	public static String name;
	public static int marks;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student id");
		id=sc.nextInt();
		System.out.println("enter Student name");
		name=sc.next();
		System.out.println("enter marks");
		marks=sc.nextInt();
	}
	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		LinkedList l=new LinkedList();
		getDetails();
		a.add(new Student(id,name,marks));
		l.add(new Student(id,name,marks));
		getDetails();
		a.add(new Student(id,name,marks));
		l.add(new Student(id,name,marks));
		getDetails();
		a.add(new Student(id,name,marks));
		l.add(new Student(id,name,marks));
		System.out.println("ArrayList "+a);
		System.out.println("Linked List "+l);
	}
}
