package com.airlinesproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airlinesproducer.helper.JwtTokenUtil;
import com.airlinesproducer.model.JwtResponse;
import com.airlinesproducer.model.User;
import com.airlinesproducer.service.CustomUserDetailService;


@RestController
public class JWTController {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	public CustomUserDetailService getCustomUserDetailService() {
		return customUserDetailService;
	}

	public void setCustomUserDetailService(CustomUserDetailService customUserDetailService) {
		this.customUserDetailService = customUserDetailService;
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
	public ResponseEntity<?> generateToken(@RequestBody User user){
		try {
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
			
		}catch(UsernameNotFoundException ue)
		{
			throw new UsernameNotFoundException("user not found");
		}
		UserDetails ud=this.customUserDetailService.loadUserByUsername(user.getUsername());

		String token=this.jwttokenutil.generateToken(ud);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
