package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeNotFoundException;
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
		System.out.println(employee.getCredential().getPassword());
		//employee.getCredential().setPassword(this.bpc.encode(employee.getCredential().getPassword()));
		return employeeRepository.save(employee);
	}
	//This method is used to uodate employee data
	public Employee update(Employee employee,int empid) {
		Optional<Employee> optional = employeeRepository.findById(empid);
        if (optional.isPresent()) {
        	employee.setEmpId(empid);
            return employeeRepository.save(employee);
        }
        else
           throw new EmployeeNotFoundException("Employee not found for id : " + empid);
	}
	//This method getting the employee details using username
	public Employee getEmpByUsername(String username) {
		Employee emp=employeeRepository.findByCredential(username);
		return emp;
	}
	//This method is used to getting all Employees
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	 public Employee getEmployeeById(int empid) 
	 { 
		try {
			return employeeRepository.findById(empid).get();
		}
		catch(EmployeeNotFoundException e){
			throw new EmployeeNotFoundException("employee not found");
		}
	 }
	 //this method used to delete employee details
	 public void deleteEmployee(int empid) {
		 employeeRepository.deleteById(empid);
	 }
}
