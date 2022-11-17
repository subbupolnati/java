package com.inventorymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventorymanagementsystem.helper.JwtTokenUtil;
import com.inventorymanagementsystem.model.JwtResponse;
import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.service.UserService;


@Controller
public class JWTController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
			
		}catch(UsernameNotFoundException ue){
			throw new UsernameNotFoundException("user not found");
		}	
		UserDetails ud=this.userService.loadUserByUsername(user.getUsername());

		String token=this.jwttokenutil.generateToken(ud);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
	
