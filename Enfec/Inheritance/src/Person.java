import java.util.*;
public class Person {
	int pid;
	String pname;
	Scanner sc=new Scanner(System.in);
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	void setData() {
		System.out.println("enter pid");
		pid=sc.nextInt();
	}
	void setData(int pid) {
		System.out.println("enter pname");
		pname=sc.next();
	}
	void getData() {
		System.out.println(" pid "+pid);
		System.out.println("pname "+pname);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s=new Student(10,"subbu");
		s.setData();
		s.getData();
	}
}
class Student extends Person{
	public Student(int pid,String pname) {
		super(pid,pname);
	}
	void setData() {
		super.setData();
		super.setData(pid);
	}
	void getData() {
		super.getData();
	}
	
}