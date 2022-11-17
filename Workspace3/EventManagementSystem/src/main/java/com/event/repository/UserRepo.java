package com.event.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
public User findByUsernameAndPasswordAndRole(String username,String password,String role);

public Optional<User> findByUsername(String username);
}
