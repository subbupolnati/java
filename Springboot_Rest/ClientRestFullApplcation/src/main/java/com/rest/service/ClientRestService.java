package com.rest.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.model.Employee;

@Service
public class ClientRestService {
	
	RestTemplate template;

	public ClientRestService(RestTemplate template) {
		super();
		this.template = template;
	}

	public ResponseEntity<Employee> searchEmployeeById(int empid){
		String url="http://localhost:8080/employee/"+empid;
		ResponseEntity<Employee> entity=template.getForEntity(url,Employee.class);
		Employee e=entity.getBody();
		return entity;
	}
	public ResponseEntity<Employee[]> showAllEmp(){
		String url="http://localhost:8080/employee";
		HttpEntity<Employee> entity=new HttpEntity<Employee>(null,null);
		ResponseEntity<Employee[]> response=template.exchange(url,HttpMethod.GET,entity,Employee[].class);
		return response;
	}
	public ResponseEntity<Employee> insertNewEmp(Employee employee) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/employee");
		HttpEntity<Employee> entity=new HttpEntity<Employee>(employee,null);
		ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.POST,entity,Employee.class);
		return response;
	}
	public ResponseEntity<Employee>updateEmployee(int empid,Employee employee) throws URISyntaxException{
		String url="http://localhost:8080/employee/"+empid;
		HttpEntity<Employee> entity=new HttpEntity<Employee>(employee,null); 
		ResponseEntity<Employee> response=template.exchange(url,HttpMethod.PUT,entity,Employee.class); 
		return response;
	}
	public ResponseEntity<Employee> DeleteEmployeeById(int empid) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/employee/"+empid);
		HttpEntity<Employee> entity=new HttpEntity<Employee>(null,null);
		ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.DELETE,entity,Employee.class);
		return response;
	}
	
}
