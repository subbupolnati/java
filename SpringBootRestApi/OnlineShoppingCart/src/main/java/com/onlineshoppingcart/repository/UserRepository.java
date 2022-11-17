package com.onlineshoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshoppingcart.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
	public User findByUseridAndPasswordAndRole(String userid,String password,String role);
}
