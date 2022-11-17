package com.inventory.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.controller.UserController;
import com.inventory.model.Permission;
import com.inventory.model.Supplier;

@Service
public class PermissionService {

	RestTemplate template;
	@Autowired
	private UserService us;
	public PermissionService(RestTemplate template) {
		super();
		this.template = template;
	}
	public List<Permission> getAllPermissions(){
		String url="http://localhost:8080/permissions";
		HttpEntity<Permission> entity= new HttpEntity<Permission>(null,null);
		ResponseEntity<Permission[]> response=template.exchange(url,HttpMethod.GET,entity,Permission[].class);
		Permission[] p=response.getBody();
		List<Permission> per=Arrays.asList(p);
		return per;
	}
	public ResponseEntity<Permission> addPermission(Permission permission) {
		String url="http://localhost:8080/permission";
		HttpHeaders headers=us.getHeaders();
		//System.out.println("uswerrr"+UserController.token);
		//System.out.println("peintllllllllllll");
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Permission> entity= new HttpEntity<Permission>(permission,headers);
		ResponseEntity<Permission> response=template.postForEntity(url,entity,Permission.class);
		return response;
	}
}
