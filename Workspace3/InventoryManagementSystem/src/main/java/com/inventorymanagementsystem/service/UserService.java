package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.repository.UserRepo;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepo ur;

	public User addUser(User user) {
		return ur.save(user);
	}
	public List<User> getAllUser(){
		try{
			return ur.findAll();
		}catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("user Not Found");
		}
	}
	public User editUser(User user,String username) {
		Optional<User> optional=ur.findById(username);
		if(optional.isPresent()) {
			user=optional.get();
			return user;
		}
		else
			throw new UsernameNotFoundException("user Not Found"+username);
	}
	public void deleteUser(String username) {
		try{
			ur.deleteById(username);
		}catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("user Not Found"+username);
		}
	}
	/*public List<User> searchUser(String username){
		return (List<User>) ur.findByUsername(username);
	}*/
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
			User user=ur.findByUsername(username);
			return new CustomUserDetail(user);
	}
	public User validate(String username) {
		return ur.findByUsername(username);
	}
}
