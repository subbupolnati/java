package com.employee.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.model.Employee;
import com.employee.model.User;
import com.employee.service.EmployeeRestService;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployeeRestService employeeRestService;
	@GetMapping("/")
	public String getThirdPartApiData() {
		return employeeRestService.callThirdPartyAPI();
	}
	@PostMapping("/login")
	public void login(@RequestBody User user) {
		employeeRestService.login(user);
	}
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> searchEmployeeById(@PathVariable("empid") int empid){
		return employeeRestService.searchEmployeeById(empid);
	}
	@GetMapping("/employees")
	public ResponseEntity<Employee[]> showAllEmployees(){
		
		return employeeRestService.showAllEmployees();
	}
	@PostMapping("/employee")
	public ResponseEntity<Employee>addNewEmployee(@RequestBody Employee employee) throws URISyntaxException{
		
		return employeeRestService.addNewEmployee(employee);
	}
	@PutMapping("/employee/{empid}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable("empid") int empid,@RequestBody Employee employee) throws URISyntaxException{
		
		return employeeRestService.updateEmployee(empid,employee);
	}
	@DeleteMapping("/employee/{empid}")
	public ResponseEntity<Employee>deleteEmployee(@PathVariable("empid") int empid) throws URISyntaxException{
		
		return employeeRestService.DeleteEmployeeById(empid);
	}
}
