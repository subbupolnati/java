package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.repository.PermissionRepo;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepo prepo;
	
	public Permission addPermission(Permission permission) {
		return prepo.save(permission);
	}
	public List<Permission> getPermissions(){
		return prepo.findAll();
	}
	public Permission editPermission(int permissionid) {
		Optional<Permission> optional=prepo.findById(permissionid);
		Permission permission=null;
		if(optional.isPresent()) {
			permission=optional.get();
			return permission;
		}
		return permission;
	}
	public void deletePermission(int permissionid) {
		prepo.deleteById(permissionid);
	}
	public List<Permission> searchPermission(int permissionid){
		return prepo.findByPermissionid(permissionid);
	}
}
