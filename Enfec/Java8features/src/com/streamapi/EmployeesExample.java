package com.streamapi;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.streamapi.Employees;
public class EmployeesExample {
	public static int eid;
	public static String ename;
	public static int age;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id");
		eid=sc.nextInt();
		System.out.println("enter employee ename");
		ename=sc.next();
		System.out.println("enter employee age");
		age=sc.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employees> emp=new ArrayList<Employees>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter how many employess created");
		int n=sc.nextInt();
		int i=0;
		while(i<n) {
			getDetails();
			emp.add(new Employees(eid,ename,age));
			i++;
		}
		System.out.println(emp);
		 List<String> enamelist = emp.stream().filter(e->e.getAge()>20).map(Employees::getEname).collect(Collectors.toList());
		 enamelist.forEach((name)-> System.out.println(name));
		 long l1= emp.stream().filter(x->x.getAge()==25).count();
		 System.out.println("with age 25 employess count: "+l1);
		 Optional<Employees> el=emp.stream().filter(e->e.getEname().equalsIgnoreCase("Mary")).findAny();
		 if(el.isPresent())
			 System.out.println(el.get());
		OptionalInt mxage=emp.stream().mapToInt(Employees::getAge).max();
		if(mxage.isPresent())
			 System.out.println("Maximum age of employee"+mxage.getAsInt());
		emp.sort((e1,e2)->e1.getAge()-e2.getAge());
		emp.forEach(a->System.out.println(a));
	}
}
