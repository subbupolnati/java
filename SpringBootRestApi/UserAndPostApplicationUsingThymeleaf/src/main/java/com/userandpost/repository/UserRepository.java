package com.userandpost.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.userandpost.model.Response;
import com.userandpost.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query(value="select * from users where company_name=?1", nativeQuery = true)
	public List<Users> findByCompanyName(String companyname);
	//@Query(value="select users.name,users.id,count(posts.user_id)as count from users INNER JOIN posts on users.id=posts.user_id GROUP BY users.name,users.id")
	//public List<Response> findByPostCount();
	
}
