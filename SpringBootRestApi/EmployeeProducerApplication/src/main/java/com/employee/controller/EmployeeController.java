package com.employee.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.helper.JwtTokenUtil;
import com.employee.model.Employee;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@RestController
//This is a employee Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;//injecting Employee Service dependenecy
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	//Getter and setter methods
	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	public JwtTokenUtil getJwttokenutil() {
		return jwttokenutil;
	}

	public void setJwttokenutil(JwtTokenUtil jwttokenutil) {
		this.jwttokenutil = jwttokenutil;
	}

	public AuthenticationManager getMgr() {
		return mgr;
	}

	public void setMgr(AuthenticationManager mgr) {
		this.mgr = mgr;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//THis Url is navigate to user save page
	@PostMapping("/employee")
	public Employee insertUser(@Valid @RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
		//URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}").buildAndExpand(e.getEmpId()).toUri();
		//return ResponseEntity.created(location).build();
	}
	//getting all employee details
	@GetMapping("/employees")
	public List<Employee>getAllEmployees(){
		return employeeService.getAllEmp();
	}
	//Get employee details based on username
	@GetMapping("/employee/{username}")
	public Employee employeeByUserName(@PathVariable("username")String username) {
		return employeeService.getEmpByUsername(username);
	}
	//gettin employee details based on employee id
	@GetMapping("/employee/empid/{empid}") 
	public Employee employeeGetById(@PathVariable("empid")int empid)
	{ 
		return employeeService.getEmployeeById(empid);
	}
	//update based on employee id	
	@PutMapping("/employee/{empid}")
	public Employee updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("empid") int empid) {
		return employeeService.update(employee,empid);
	}
	@DeleteMapping("/employee/{empid}")
	public void employeeDelete(@PathVariable("empid")int empid) {
		employeeService.deleteEmployee(empid);
	}
}
