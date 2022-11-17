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

import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.service.PermissionService;

@RestController
public class PermissionController {

	@Autowired
	private PermissionService ps;
	
	
	@PostMapping("/permission")
	public Permission insertPermission(@RequestBody Permission permission) {
		return ps.addPermission(permission);
	}
	@GetMapping("/permissions")
	public List<Permission> getPermission() {
		return ps.getPermissions();
	}
	@PostMapping("/permission/{id}")
	public List<Permission> searchPermission(@PathVariable("id") int id,Model m) {
		 return ps.searchPermission(id);
	}
	@PutMapping("/permission/{id}")
	public Permission updatePermission(@RequestBody Permission permission,@PathVariable("id")int id,Model m) {
		return ps.editPermission(permission, id);
	}
	@DeleteMapping("/permission/{id}")
	public void deletePermission(@PathVariable("id") int id,Model m) {
		ps.deletePermission(id);
	}
}
