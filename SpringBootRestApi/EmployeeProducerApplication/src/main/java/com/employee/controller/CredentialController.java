package com.employee.controller;

import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.model.Credential;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@RestController
public class CredentialController {

	@Autowired 
	private CredentialService credentialService;//injecting Credential Service dependenecy
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	@Autowired
	private EmployeeService employeeService;//injecting Employee Service dependenecy
	
	//Getter and setter methods
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	//THis Url is navigate to after a enter register details saving to database using Jpa Reposioty
	@PostMapping("/credential/save")
	public ResponseEntity<Credential> insert(@Valid @RequestBody Credential credential) {
			credential.setPassword(this.bPasswordEncoder.encode(credential.getPassword()));
			Credential c=credentialService.insert(credential);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{userName}").buildAndExpand(c.getUserName()).toUri();
			return ResponseEntity.created(location).build();
	}
	@GetMapping("/checkUser/{username}")
	public Credential getUser(@PathVariable("username") String username) {
		return credentialService.validate(username);
	}
}
