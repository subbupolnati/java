package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.PermissionNotFoundException;
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
		try {
			return prepo.findAll();
		}catch(PermissionNotFoundException e) {
			throw new PermissionNotFoundException("permission not found");
		}
	}
	public Permission editPermission(Permission permission,int permissionid) {
		Optional<Permission> optional=prepo.findById(permissionid);
		if(optional.isPresent()) {
			permission=optional.get();
			return prepo.save(permission);
		}
		throw new PermissionNotFoundException("permission not found"+permissionid);
	}
	public void deletePermission(int permissionid) {
		try{
			prepo.deleteById(permissionid);
		}
		catch(PermissionNotFoundException e) {
			throw new PermissionNotFoundException("permission not found"+permissionid);
		}
	}
	public List<Permission> searchPermission(int permissionid){
		try{
			return prepo.findByPermissionid(permissionid);
		}
		catch(PermissionNotFoundException e) {
			throw new PermissionNotFoundException("permission not found"+permissionid);
		}
	}
}
