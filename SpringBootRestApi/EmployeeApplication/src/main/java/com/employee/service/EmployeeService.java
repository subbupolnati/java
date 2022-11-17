package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

import java.util.List;


@Service
//Service class
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;//Employee Repository dependecies
	//getter and setter
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//This method is used to insert new Employee Data
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	//This method is used to uodate employee data
	public Employee update(int empid) {
		Optional<Employee> optional = employeeRepository.findById(empid);
		Employee employee=null;
        if (optional.isPresent()) {
        	employee=optional.get();
            return employeeRepository.save(employee);
        }
        else
           //throw new RuntimeException("Employee not found for id : " + empid);
        	return employee;
	}
	//This method getting the employee details using username
	public Employee getEmp(String username) {
		Employee emp=employeeRepository.findUserName(username);
		return emp;
	}
	//This method is used to getting all Employees
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	//This method is used update employee details based on username
	public Employee updateByUsername(String username) {
	
		Employee employee=employeeRepository.findUserName(username);
           return employeeRepository.save(employee);
	}
}
