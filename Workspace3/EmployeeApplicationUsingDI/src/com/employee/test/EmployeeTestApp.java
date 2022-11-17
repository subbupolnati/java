package com.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.bean.Employee;

public class EmployeeTestApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/com/employee/resource/Beans.xml");
		Employee e=(Employee)ctx.getBean("emp");
		System.out.println(e.toString());
	}

}
