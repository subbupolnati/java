package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exam.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUsernameAndPasswordAndUsertype(String username, String password, String role);
}
