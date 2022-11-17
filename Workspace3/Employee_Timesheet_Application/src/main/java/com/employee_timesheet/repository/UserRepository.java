package com.employee_timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_timesheet.model.Users;

@Repository
//This interface define userRepository 
public interface UserRepository extends JpaRepository<Users,Integer>{
	//this method find by user based n official mail id  
	public Users findByOfficialMail(String username);
}
