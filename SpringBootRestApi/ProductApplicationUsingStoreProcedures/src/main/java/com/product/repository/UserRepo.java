package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Procedure(procedureName = "insert_users")
	//@Query(value = "{call insert_users(?,?,?,?)}", nativeQuery = true)
	void save(@Param("uid")String uid,@Param("uname")String uname,@Param("pass")String pass,@Param("utype")String utype);
	User findByUseridAndPasswordAndType(String user_id, String password, String type);
}
