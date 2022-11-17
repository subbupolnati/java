package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.model.Employee;

@Component
public interface EmployeeService {
	
	List<Employee>getEmployeeDetails(Employee employee);
	Employee getEmployeeById(int id);
}
