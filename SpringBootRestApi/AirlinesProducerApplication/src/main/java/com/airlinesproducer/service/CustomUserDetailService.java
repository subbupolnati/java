package com.airlinesproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airlinesproducer.model.User;
import com.airlinesproducer.repository.UserRepository;



@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserRepository getUr() {
		return userRepository;
	}
	public void setUr(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=userRepository.findByUsername(username);
		return new CustomUserDetail(u);
	}
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
}
