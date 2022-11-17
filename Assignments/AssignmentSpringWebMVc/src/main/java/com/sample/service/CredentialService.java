package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.model.Credential;
import com.sample.reposiroty.CredentialRepository;

@Service
public class CredentialService {

	@Autowired
	private CredentialRepository credentialRepository;

	public CredentialRepository getCredentialRepository() {
		return credentialRepository;
	}

	public void setCredentialRepository(CredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}
	
	public Credential insert(Credential credential) {
		return credentialRepository.save(credential);
	}
	public Credential validate(String username,String password) {
		Credential c=credentialRepository.findByUsernameAndPassword(username, password);
		return c;
		}
}
