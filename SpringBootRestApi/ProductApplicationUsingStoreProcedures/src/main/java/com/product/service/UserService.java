package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.User;
import com.product.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	public void addNewUser(String uid,String uname,String pass,String utype) {
		userRepo.save(uid,uname,pass,utype);
	}
	
	 public User validate(String user_id, String password, String type) { 
		 User u=userRepo.findByUseridAndPasswordAndType(user_id, password, type); 
		 return u; 
		 }
}
