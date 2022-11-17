package com.employee_timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee_timesheet.helper.JwtTokenUtil;
import com.employee_timesheet.model.JwtResponse;
import com.employee_timesheet.model.Users;
import com.employee_timesheet.service.CustomUserDetailService;
//This class acts like Controller checking urls
@Controller
public class JWTController {

	@Autowired //this Autowired annotations inject CustomUserDetailService dependencies
	private CustomUserDetailService customUserDetailService;
	//this Autowired annotations inject jwttokenutil dependencies
	@Autowired
	private JwtTokenUtil jwttokenutil;
	//this Autowired annotations inject AuthenticationManage dependencies
	@Autowired 
	private AuthenticationManager mgr;
	

	//setter and getter methods
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
	//in this url and method is using login user and authenticate user name and password and generate jwt token
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody Users users){
		try {
			//this authenticate method validate username and password based on user data  
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(users.getOfficialMail(),users.getPassword()));
			
		}catch(UsernameNotFoundException ue){
			throw new UsernameNotFoundException("user not found");
		}	
		//this statement validate user name  based on user data and return user details
		UserDetails ud=this.customUserDetailService.loadUserByUsername(users.getOfficialMail());
		//this statement generate token based on user details
		String token=this.jwttokenutil.generateToken(ud);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
	
