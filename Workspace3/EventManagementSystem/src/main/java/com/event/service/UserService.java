package com.event.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.event.model.User;
import com.event.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	public User addUser(User user) {
		Optional<User>optional=userRepo.findByUsername(user.getUsername());
		if(!optional.isPresent())
			return userRepo.save(user);
		else
			throw new UsernameNotFoundException("already exists");
	}
	public void deleteUser(String username) {
		 userRepo.deleteById(username);
	}
	/*public User validate(String username,String password,String role) {
		return userRepo.findByUsernameAndPasswordAndRole(username, password, role);
	}*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUsername(username).get();
		return new CustomUserDetail(user);
	}
	public User validate(String username) {
		return userRepo.findByUsername(username).get();
	}
}
