package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

	public List<Role> findByRoleid(int roleid);
}
