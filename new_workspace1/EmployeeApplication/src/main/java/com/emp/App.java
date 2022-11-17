package com.emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emp.dao.EmployeeDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeDAO eda=(EmployeeDAO)ctx.getBean("edao");
        Employee e=new Employee();
        e.setEmpid(100);
        e.setEname("subbu");
        e.setSalary(15000);
        eda.insertEmployee(e);
        System.out.println("inserted successfully");
    }
}
