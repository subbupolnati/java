package com.sample.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.model.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {
	Credential findByUsernameAndPassword(String username, String password);
}
