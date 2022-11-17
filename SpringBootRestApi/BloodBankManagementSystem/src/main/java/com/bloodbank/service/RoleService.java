package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Role;
import com.bloodbank.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}
	public List<Role> getAllRoles(){
		return roleRepo.findAll();
	}
	public List<Role> searchRole(int roleid) {
		return roleRepo.findByRoleid(roleid);
	}
	public Role updateRole(int roleid) {
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
	
}
