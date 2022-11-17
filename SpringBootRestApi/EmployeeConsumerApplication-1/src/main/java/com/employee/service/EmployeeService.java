package com.employee.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.model.Credential;
import com.employee.model.Employee;
import com.employee.model.JwtResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;


@Service
//Service class
public class EmployeeService {

RestTemplate restTemplate;
	
	
	public EmployeeService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	static String token;
	//Authentication
	public ResponseEntity<JwtResponse> getToken(Credential credential){
		String url="http://localhost:8080/login";
		//HttpHeaders headers = getHeaders();
		HttpEntity<Credential> entity=new HttpEntity<Credential>(credential);
		ResponseEntity<JwtResponse> response=restTemplate.exchange(url,HttpMethod.POST,entity,JwtResponse.class);
		return response;
	
	}
	//Tohen generation
	public void getTokenResponse(Credential credential) {
		ResponseEntity<JwtResponse> jwtToken=this.getToken(credential);
		System.out.println(jwtToken.getBody().getToken());
		token="Bearer "+jwtToken.getBody().getToken();
		System.out.println("after appending"+token);
	}
	//This method is used to getting all Employees
	public List<Employee>getAllEmp(){
		String url="http://localhost:8080/employees";
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(null,headers);
		ResponseEntity<Employee[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Employee[].class);
		Employee[] emp=response.getBody();
		List<Employee> employee=Arrays.asList(emp);
		return employee;
	}
	//This method getting the employee details using username
	public Employee getEmp(String username) {
		String url="http://localhost:8080/employee/"+username;
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(null,headers);
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.GET,entity,Employee.class);
		return response.getBody();
	}
	//get Employee Details based on employee id
	public Employee getEmployee(int empid) {
		String url="http://localhost:8080/employee/empid/"+empid;
		Employee employee=null;
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(employee,headers);
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.GET,entity,Employee.class);
		return response.getBody();
	}
	//This method is used to insert employee details
	public Employee insertEmp(Employee employee)throws URISyntaxException {
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(employee,headers);
		URI uri=new URI("http://localhost:8080/employee");
		ResponseEntity<Employee> response=restTemplate.exchange(uri,HttpMethod.POST,entity,Employee.class);
		System.out.println(response.getBody());
		return response.getBody();
	}
	//This method is used to uodate employee data
	public Employee update(Employee employee,int empid) {
		//System.out.println("after Updating password"+employee.getCredential().getPassword());
		String url="http://localhost:8080/employee/"+empid;
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(employee,headers);
		System.out.println(entity);
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.PUT,entity,Employee.class);
		return response.getBody();
	}
	//This method is used update employee details based on username
	public Employee updateByUsername(String username) {
		String url="http://localhost:8080/employee/updateByusername/"+username;
		Employee employee=null;
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(employee,headers);
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.PUT,entity,Employee.class);
		return response.getBody();
	}
	public void deleteEmployee(int empid) {
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<Employee> entity= new HttpEntity<Employee>(null,headers);
		String url="http://localhost:8080/employee/"+empid;
		ResponseEntity<Employee> response=restTemplate.exchange(url,HttpMethod.DELETE,entity,Employee.class);
	}
	public void logout() {
		token=null;
	}
	//This method is used to set headers content
		 private HttpHeaders getHeaders() {
		        HttpHeaders headers = new HttpHeaders();
		        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		        return headers;
		    }
}
