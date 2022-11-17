package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.helper.CipherPassword;
import com.employee.model.Credential;
import com.employee.repository.CredentialRepository;

@Service("CredentialService")
//CredentialService class
public class CredentialService implements UserDetailsService {

	@Autowired
	private CredentialRepository credentialRepository;//Injecting credential Repository dependencies

	public CredentialRepository getCredentialRepository() {
		return credentialRepository;
	}

	public void setCredentialRepository(CredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}
	//insert new Credentilas
	public Credential insert(Credential credential) {
		//credential.setPassword(CipherPassword.encrypt(credential.getPassword()));
		return credentialRepository.save(credential);
	}
	//Validate credentials
	public Credential validate(String username,String password,String role) {
		Credential c=credentialRepository.findByUserName(username);
		c.setPassword(CipherPassword.decrypt(password));
		return c;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential=credentialRepository.findByUserName(username);
		return new CustomUserDetail(credential);
	}
}
