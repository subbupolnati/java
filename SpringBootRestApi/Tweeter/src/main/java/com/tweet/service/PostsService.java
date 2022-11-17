package com.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.model.Posts;
import com.tweet.repository.PostsRepository;

@Service
public class PostsService {

	@Autowired
	private PostsRepository postRepository;

	public PostsRepository getPostRepository() {
		return postRepository;
	}

	public void setPostRepository(PostsRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Posts insertNewPost(Posts post) {
		return postRepository.save(post);
	}
	public List<Posts> viewAllPosts(){
		return postRepository.findAll();
	}
	public List<Posts> getAllPosts(String userName) {
		return postRepository.findUserName(userName);
	}
	public void deletePost(int id) {
		postRepository.deleteById(id); 
	}
}
