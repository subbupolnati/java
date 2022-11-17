package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.sample.model.Employee;
import com.sample.reposiroty.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
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
	public Employee getEmp(String username) {
		Optional<Employee> optional = employeeRepository.findByUsername(username);
		Employee emp=null;
		if(optional.isPresent()) {
			emp=optional.get();
			return emp;
		}
		else 
			//throw new RuntimeException("Employee not found plese Register");
			return emp;
	}
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	public Employee updateByUsername(String username) {
		Optional<Employee> emp=employeeRepository.findByUsername(username);
		Employee employee=null;
		if(emp.isPresent())
			employee=emp.get();
           return employeeRepository.save(employee);
	}
}
