package com.employee.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.employee.model.Credential;

@Configuration
public class CustomUserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	Credential credential;
	
	public CustomUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomUserDetail(Credential credential) {
		super();
		this.credential = credential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<GrantedAuthority> hs=new HashSet<GrantedAuthority>();
		hs.add(new SimpleGrantedAuthority(this.credential.getRole()));
		return hs;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.credential.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.credential.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
