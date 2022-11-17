package com.employee.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.model.Department;
import com.employee.model.Employee;

@Service
public class DepartmentRestService {
	
	RestTemplate template;

	public DepartmentRestService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Department> searchDeptById(int did){
		String url="http://localhost:8080/dept/"+did;
		ResponseEntity<Department> entity=template.getForEntity(url,Department.class);
		Department d=entity.getBody();
		return entity;
	}
	public ResponseEntity<Department[]> showAllDept(){
		String url="http://localhost:8080/dept";
		HttpEntity entity=new HttpEntity<>(null,null);
		ResponseEntity<Department[]> response=template.exchange(url,HttpMethod.GET,entity,Department[].class);
		return response;
	}
	public ResponseEntity<Department>addNewDept(Department department) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/dept");
		HttpEntity<Department> entity=new HttpEntity<Department>(department,null);
		ResponseEntity<Department> response=template.exchange(uri,HttpMethod.POST,entity,Department.class);
		return response;
	}
	public ResponseEntity<Department>updateDept(int did) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/dept/"+did);
		ResponseEntity<Department> entity=template.getForEntity(uri,Department.class);
		Department dept=entity.getBody();
		HttpEntity<Department> entity1=new HttpEntity<Department>(dept,null);
		ResponseEntity<Department> response=template.exchange(uri,HttpMethod.PUT,entity,Department.class);
		return response;
	}
	public ResponseEntity<Department> DeleteDeptById(int did) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/dept/"+did);
		ResponseEntity<Department> entity=template.getForEntity(uri,Department.class);
		Department d=entity.getBody();
		HttpEntity<Department> entity1=new HttpEntity<Department>(d,null);
		ResponseEntity<Department> response=template.exchange(uri,HttpMethod.DELETE,entity,Department.class);
		return response;
	}
}
