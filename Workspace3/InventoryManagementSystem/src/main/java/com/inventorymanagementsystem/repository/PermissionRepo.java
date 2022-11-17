package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Integer>{

	public List<Permission> findByPermissionid(int permissionid);
}
