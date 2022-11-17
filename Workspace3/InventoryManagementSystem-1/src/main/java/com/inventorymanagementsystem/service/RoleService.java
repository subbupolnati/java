package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Role;
import com.inventorymanagementsystem.repository.RoleRepo;

@Service
public class RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}
	public List<Role> getAllRole(){
		return roleRepo.findAll();
	}
	public Role editRole(int roleid) {
		Optional<Role> optional=roleRepo.findById(roleid);
		Role role=null;
		if(optional.isPresent()) {
			role=optional.get();
			return role;
		}
		return role;
	}
	public void deleteRole(int roleid) {
		roleRepo.deleteById(roleid);
	}
	public List<Role> searchRole(int roleid){
		return roleRepo.findByRoleid(roleid);
	}
}
