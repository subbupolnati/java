package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO edo;
	@Override
	public List<Employee> getEmployeeDetails(Employee employee) {
		
		return edo.showEmployeeDetails(employee);
	}
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return edo.getEmployeeByID(id);
	}
}
