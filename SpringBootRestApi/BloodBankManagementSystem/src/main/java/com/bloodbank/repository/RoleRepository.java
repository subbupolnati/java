package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public List<Role> findByRoleid(int roleid);
	}
