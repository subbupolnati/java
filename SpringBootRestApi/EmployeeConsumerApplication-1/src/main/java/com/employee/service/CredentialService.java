package com.employee.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.model.Credential;


@Service("CredentialService")
//CredentialService class
public class CredentialService  {

	RestTemplate restTemplate;
	
	
	public CredentialService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}


	//insert new Credentilas
	public ResponseEntity<Credential> insert(Credential credential) {
		String url="http://localhost:8080/credential/save";
		HttpEntity<Credential> entity=new HttpEntity<Credential>(credential,null);
		ResponseEntity<Credential> response=restTemplate.postForEntity(url,entity,Credential.class);
		return response;
	}
	//Validate credentials
	public Credential validate(String username) {
		String url="http://localhost:8080/checkUser/"+username;
		return restTemplate.getForObject(url,Credential.class);
	}
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential=credentialRepository.findByUserName(username);
		return new CustomUserDetail(credential);
	}*/
}
