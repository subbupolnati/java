package com.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tweet.model.Posts;

public interface PostsRepository extends JpaRepository<Posts,Integer>{
	@Query(value="select * from posts1 where  user_user_name=?1", nativeQuery = true)
	public List<Posts> findUserName(String username);
}
