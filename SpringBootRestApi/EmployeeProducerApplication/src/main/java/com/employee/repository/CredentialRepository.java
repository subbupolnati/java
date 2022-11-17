package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Credential;


@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {
	public Credential findByUserName(String username);
}
