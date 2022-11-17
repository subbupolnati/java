package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Users;
import com.employee_timesheet.repository.UserRepository;
//this class is used to service write n database business logics
@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	//this Autowired annotations inject UserRepository dependencies
	@Autowired
	private UserRepository userRepository;
	//setter and getter 
	public UserRepository getUr() {
		return userRepository;
	}
	public void setUr(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	//This method override loadbyusername method in userDetailsService class 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u=userRepository.findByOfficialMail(username);
		return new CustomUserDetail(u);
	}
	//this method save the user data in database
	public Users insertUser(Users users) {
		return userRepository.save(users);
	}
	//this method getting the all user data in database
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	//this method getting user details based on userOfficial mail 
	public Users getuserByOfficialMail(String officialMail) {
		//this statement get user based on id if user is not available optional is null
		Users user=userRepository.findByOfficialMail(officialMail);
		//if user instance not null execute if block other wise it returns comment null;
		if(user.equals(null))
			throw new NotFoundException("user not found for id : " +officialMail);
		return user;
	}
	//this method update user based on userId
	public Users updateUser(Users user,int userId) {
		Optional<Users> optional=userRepository.findById(userId);
	    if (optional.isPresent()) {
	    	user.setUserId(userId);
	        return userRepository.save(user);
	    }
	    else
	       throw new NotFoundException("Comment not found for id : " +userId);
	}
	//In this method delete comment based on id
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
}
