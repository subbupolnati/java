package com.employee.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.model.Employee;
import com.employee.model.JwtResponse;
import com.employee.model.User;

@Service
public class EmployeeRestService {

	RestTemplate template;
	
	ResponseEntity<JwtResponse> authenticationResponse;
	public EmployeeRestService(RestTemplate template) {
		super();
		this.template = template;
	}
	public String callThirdPartyAPI() {
		return template.getForObject("http://localhost:8080/home",String.class);
	}
	
	public void login(User user){
		String loginurl="http://localhost:8080/login";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity request=new HttpEntity(headers);
		authenticationResponse = template.exchange(loginurl,HttpMethod.POST, request, JwtResponse.class);
	}
	public ResponseEntity<Employee> searchEmployeeById(int empid){
		String url="http://localhost:8080/employee/"+empid;
		ResponseEntity<Employee> entity=template.getForEntity(url,Employee.class);
		Employee e=entity.getBody();
		return entity;
	}
	public ResponseEntity<Employee[]> showAllEmployees(){
		if (authenticationResponse !=null && authenticationResponse.getStatusCode().equals(HttpStatus.OK)) 
		{
			String token = "Bearer " + authenticationResponse.getBody();
			String url="http://localhost:8080/employees";
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", token);
			HttpEntity<Employee> entity=new HttpEntity<Employee>(null,headers);
			ResponseEntity<Employee[]> response=template.exchange(url,HttpMethod.GET,entity,Employee[].class);
			return response;
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<Employee>addNewEmployee(Employee employee) throws URISyntaxException{
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
		ResponseEntity<Employee> entity=template.getForEntity(uri,Employee.class);
		Employee e=entity.getBody();
		HttpEntity<Employee> entity1=new HttpEntity<Employee>(e,null);
		ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.DELETE,entity1,Employee.class);
		return response;
	}
}
