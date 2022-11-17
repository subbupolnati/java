package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByUserid(int userid);
}
