package com.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employeeexception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository er;
	

	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeService(EmployeeRepository er) {
		super();
		this.er = er;
	}

	public EmployeeRepository getEr() {
		return er;
	}

	public void setEr(EmployeeRepository er) {
		this.er = er;
	}
	
	public Employee insertEmployee(Employee employee) {
		return er.save(employee);
	}
	public List<Employee> getAllEmployees(){
		return er.findAll();
	}
	public void deleteEmployee(int empid) {
		try {
			er.deleteById(empid);
		}
		catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found for id : " + empid);
		}
	}
	public Employee update(Employee employee,int empid) {
		Optional<Employee> optional = er.findById(empid);
        if (optional.isPresent()) {
            employee.setEmpid(empid);
            return er.save(employee);
        }
        else
            throw new EmployeeNotFoundException("Employee not found for id : " + empid);
        //return er.save(employee);
	}
	public Employee getEmployee(int empid) {
		Optional<Employee> optional=er.findById(empid);
		Employee emp=null;
		if(optional.isPresent()) {
			emp=optional.get();
			return emp;
		}
		else
            throw new EmployeeNotFoundException("Employee not found for id : " + empid);
	}
	
}
