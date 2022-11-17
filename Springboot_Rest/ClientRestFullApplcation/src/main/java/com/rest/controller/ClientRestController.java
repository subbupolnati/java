package com.rest.controller;

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
import com.rest.model.Employee;
import com.rest.service.ClientRestService;

@RestController
public class ClientRestController {

	@Autowired
	private ClientRestService clientRestService;
	
	public ClientRestService getClientRestService() {
		return clientRestService;
	}
	public void setClientRestService(ClientRestService clientRestService) {
		this.clientRestService = clientRestService;
	}
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> searchEmployeeById(@PathVariable("empid") int empid){
		return clientRestService.searchEmployeeById(empid);
	}
	@GetMapping("/employee")
	public ResponseEntity<Employee[]> showAllEmployees(){
		
		return clientRestService.showAllEmp();
	}
	@PostMapping("/employee")
	public ResponseEntity<Employee>addNewEmployee(@RequestBody Employee employee) throws URISyntaxException{
		
		return clientRestService.insertNewEmp(employee);
	}
	@PutMapping("/employee/{empid}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable("empid") int empid,@RequestBody Employee employee) throws URISyntaxException{
		
		return clientRestService.updateEmployee(empid,employee);
	}
	@DeleteMapping("/employee/{empid}")
	public ResponseEntity<Employee>deleteEmployee(@PathVariable("empid") int empid) throws URISyntaxException{
		
		return clientRestService.DeleteEmployeeById(empid);
	}
}
