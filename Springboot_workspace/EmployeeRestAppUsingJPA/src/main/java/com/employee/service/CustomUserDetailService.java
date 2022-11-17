package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.model.User;
import com.employee.repo.UserRepository;

@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository ur;
	
	public UserRepository getUr() {
		return ur;
	}
	public void setUr(UserRepository ur) {
		this.ur = ur;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=ur.findByUsername(username);
		return new CustomUserDetail(u);
	}
	public User insertUser(User user) {
		return ur.save(user);
	}
	
}
