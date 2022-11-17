package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.model.Employee;

@Component
public class EmployeeDAO {

	List<Employee> emp=new ArrayList<Employee>();
	/*public List<Employee> showEmployeeDetails(){
		emp.add(new Employee(101,"subbu",10000));
		emp.add(new Employee(102,"ram",15000));
		return emp;
	}*/
	public List<Employee> showEmployeeDetails(Employee employee){
		emp.add(employee);
		return emp;
	}
	public Employee getEmployeeByID(int id) {
		for(Object al:emp) {
			Employee e=(Employee)al;
			if(e.getEmpid()==id) {
				System.out.println("ID present");
				return e;
			}
		}
		return null;
	}
}
