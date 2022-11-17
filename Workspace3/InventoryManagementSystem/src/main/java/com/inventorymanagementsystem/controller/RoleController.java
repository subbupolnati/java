package com.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagementsystem.model.Role;
import com.inventorymanagementsystem.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService rs;
	
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return rs.addRole(role);
		
	}
	@GetMapping("/roles")
	public List<Role> getRoles() {
		 return rs.getAllRole();
	}
	@PostMapping("/role/{id}")
	public List<Role> searchRole(@PathVariable("id") int id) {
		 return rs.searchRole(id);
	}
	@PutMapping("/role/{id}")
	public Role updateRole(@RequestBody Role role, @PathVariable("id")int id) {
		return rs.editRole(role, id);
	}
	@DeleteMapping("/role/{id}")
	public void deleteRole(@PathVariable("id") int id,Model m) {
		rs.deleteRole(id);
	}
}
