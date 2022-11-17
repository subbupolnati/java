package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.RoleNotFoundException;
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
		try{
			return roleRepo.findAll();
		}catch(RoleNotFoundException e) {
			throw new RoleNotFoundException("role not found");
		}
	}
	public Role editRole(Role role,int roleid) {
		Optional<Role> optional=roleRepo.findById(roleid);
		if(optional.isPresent()) {
			role=optional.get();
			return roleRepo.save(role);
		}
		else
			throw new RoleNotFoundException("role not found"+roleid);		
	}
	public void deleteRole(int roleid) {
		try{
			roleRepo.deleteById(roleid);
		}catch(RoleNotFoundException e) {
			throw new RoleNotFoundException("role not found"+roleid);
		}
	}
	public List<Role> searchRole(int roleid){
		try{
			return roleRepo.findByRoleid(roleid);
		}catch(RoleNotFoundException e) {
			throw new RoleNotFoundException("role not found"+roleid);
		}
	}
}
