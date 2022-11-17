package com.employee;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.bean.Employee;
import com.employee.dao.EmployeeDAO;

public class App 
{
	private static int empid;
	private static String ename;
	private static int salary;
	public static void getInsert() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id");
		empid=sc.nextInt();
		System.out.println("enter employee name");
		ename=sc.next();
		System.out.println("enter salary:");
		salary =sc.nextInt();
	}
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("/com/employee/resource/Beans.xml");
    	EmployeeDAO dao=(EmployeeDAO)ctx.getBean("bdao");
    	Employee e=new Employee();
    	getInsert();
    	//System.out.println("enter employee id");
		//empid=sc.nextInt();
    	e.setEmpid(empid);
    	e.setEname(ename);
    	e.setSalary(salary);
    	//dao.saveEmployee(e);
    	//System.out.println("data is inserted");
    	//dao.deleteEmploye(e);
    	//System.out.println("delted");
    	dao.updateEmploye(e);
    	List<Employee>b=dao.getDetails();
    	for(Employee b1:b) {
    		System.out.println(b1);
    	}
    	
    }
}
