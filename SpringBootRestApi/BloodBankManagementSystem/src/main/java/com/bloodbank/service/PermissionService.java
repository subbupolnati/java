package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Permission;
import com.bloodbank.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository permissionRepo;
	
	public Permission addPermission(Permission permission) {
		return permissionRepo.save(permission);
	}
	public List<Permission> getAllPermissions(){
		return permissionRepo.findAll();
	}
	public Permission updatePermission(int Permissionid) {
		Optional<Permission> optional=permissionRepo.findById(Permissionid);
		Permission permission=null;
		if(optional.isPresent()) {
			permission=optional.get();
			return permission;
		}
		return permission;
	}
	public void deletPermission(int permissionid) {
		permissionRepo.deleteById(permissionid);
	}
	public List<Permission> searchPermission(int permissionid){
		return permissionRepo.findByPermissionid(permissionid);
	}
}
