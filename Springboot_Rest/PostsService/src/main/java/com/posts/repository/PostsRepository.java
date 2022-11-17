package com.posts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posts.model.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
	public List<Posts> findByUserId(int userId);
}
