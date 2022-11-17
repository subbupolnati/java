package com.employee.controller;

import java.util.List;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	Logger logger=LoggerFactory.getLogger("EmployeeController.class");
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/employee")
	public Employee AddNewEmployee(@RequestBody Employee employee){
		logger.info("employee details adding");
		return employeeService.insertNewEmployee(employee);
	}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId")int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployeeById(@PathVariable("employeeId")int employeeId,@RequestBody Employee employee) {
		return employeeService.updateEmployeeById(employeeId, employee);
	}
	@DeleteMapping("/employee/{employeeId}")
	public void deleteById(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployeeById(employeeId);
	}
}
