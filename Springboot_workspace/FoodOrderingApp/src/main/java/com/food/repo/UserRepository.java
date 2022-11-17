package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

	User findByUsernameAndPasswordAndUsertype(String username, String password, String role);

	User findByUsername(String username);


}
