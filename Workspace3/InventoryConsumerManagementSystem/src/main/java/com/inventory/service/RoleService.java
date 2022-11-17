package com.inventory.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.model.Role;
import com.inventory.model.User;

@Service
public class RoleService {

	RestTemplate template;
	
	public RoleService(RestTemplate template) {
		super();
		this.template = template;
	}
	public List<Role> getAllRoles(){
		String url="http://localhost:8080/roles";
		HttpEntity<Role> entity= new HttpEntity<Role>(null,null);
		ResponseEntity<Role[]> response=template.exchange(url,HttpMethod.GET,entity,Role[].class);
		Role[] r=response.getBody();
		List<Role> role=Arrays.asList(r);
		return role;
	}
	public Role addnewRole(Role role) {
		String url="http://localhost:8080/role";
		HttpEntity<Role> entity= new HttpEntity<Role>(role,null);
		ResponseEntity<Role> response=template.exchange(url,HttpMethod.POST,entity,Role.class);
		System.out.println(response.getBody());
		return response.getBody();
	}
}
