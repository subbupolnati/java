package com.userandpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userandpost.model.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
