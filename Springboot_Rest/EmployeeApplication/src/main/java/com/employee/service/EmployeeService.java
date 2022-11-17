package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee insertNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee updateEmployeeById(int employeeId,Employee employee) {
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		if(optional.isPresent()) {
			employee.setEmployeeId(employeeId);
		}
		return employeeRepository.save(employee);
	}
	public void deleteEmployeeById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
