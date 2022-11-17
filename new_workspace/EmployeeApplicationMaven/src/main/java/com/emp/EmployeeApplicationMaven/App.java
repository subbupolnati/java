package com.emp.EmployeeApplicationMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emp.bean.Department;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/com/emp/resources/Beans.xml");
        Department d=(Department)ctx.getBean("dept");
       System.out.println("Department_id:"+d.getDept_id());
      System.out.println("Department_name:"+d.getDept_name());
      System.out.println("Department_location"+d.getDept_location());
      System.out.println("Employee_id:"+d.getEmployee().getEid());
      System.out.println("Employee_name:"+d.getEmployee().getEname());
      System.out.println("Employee_Salary:"+d.getEmployee().getSalary());
       
    }
}
