package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Permission;
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{
	public List<Permission> findByPermissionid(int permissionid);
}
