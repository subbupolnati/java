package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeexception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

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
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public void deleteEmployee(int empid) {
		try {
			employeeRepository.deleteById(empid);
		}
		catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found for id : " + empid);
		}
	}
	public Employee update(Employee employee,int empid) {
		Optional<Employee> optional = employeeRepository.findById(empid);
        if (optional.isPresent()) {
            employee.setEmpid(empid);
            return employeeRepository.save(employee);
        }
        else
            throw new EmployeeNotFoundException("Employee not found for id : " + empid);
        //return er.save(employee);
	}
	public Employee getEmployee(int empid) {
		Optional<Employee> optional=employeeRepository.findById(empid);
		Employee emp=null;
		if(optional.isPresent()) {
			emp=optional.get();
			return emp;
		}
		else
            throw new EmployeeNotFoundException("Employee not found for id : " + empid);
	}
	
}
