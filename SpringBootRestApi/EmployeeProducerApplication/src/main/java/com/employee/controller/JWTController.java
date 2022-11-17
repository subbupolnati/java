package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.employee.helper.JwtTokenUtil;
import com.employee.model.Credential;

import com.employee.model.JwtResponse;
import com.employee.service.CredentialService;


@Controller
public class JWTController {

	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	public JwtTokenUtil getJwttokenutil() {
		return jwttokenutil;
	}

	public void setJwttokenutil(JwtTokenUtil jwttokenutil) {
		this.jwttokenutil = jwttokenutil;
	}

	public AuthenticationManager getMgr() {
		return mgr;
	}

	public void setMgr(AuthenticationManager mgr) {
		this.mgr = mgr;
	}
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody Credential credential){
		try {
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(credential.getUserName(),credential.getPassword()));
			
		}catch(UsernameNotFoundException ue){
			throw new UsernameNotFoundException("user not found");
		}	
		UserDetails ud=this.credentialService.loadUserByUsername(credential.getUserName());

		String token=this.jwttokenutil.generateToken(ud);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
	
