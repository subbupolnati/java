package com.employee.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.employeeexception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
		
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee) {
		Employee e=employeeService.insertEmployee(employee);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{empid}").buildAndExpand(e.getEmpid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@DeleteMapping("/employee/{empid}")
	public void deleteEmployee(@PathVariable("empid") int empid) {
		employeeService.deleteEmployee(empid);
	}
	@PutMapping("/employee/{empid}")
	public Employee updateEmployee(@Valid @RequestBody Employee employee,@PathVariable("empid") int empid) {
		return employeeService.update(employee,empid);
	}
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empid") int empid) {
		try {
			return new ResponseEntity<>( employeeService.getEmployee(empid),HttpStatus.OK);
		}
		catch(Exception e) {
			throw new EmployeeNotFoundException("employee Id Not Found");
		}
	}
}
