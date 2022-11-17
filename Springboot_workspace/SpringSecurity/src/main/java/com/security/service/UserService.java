package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class UserService {

	List<User> ul=new ArrayList<User>();
	
	UserService(){
		ul.add(new User("enfec","abc"));
		ul.add(new User("subbu","xyz"));
		ul.add(new User("veera","zzz"));
	}
	public List<User> getAllUsers(){
		return ul;
	}
}
