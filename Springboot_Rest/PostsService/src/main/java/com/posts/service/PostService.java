package com.posts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.model.Posts;
import com.posts.repository.PostsRepository;

@Service
public class PostService {

	@Autowired
	PostsRepository postsRepository;
	
	public Posts insertPosts(Posts post) {
		return postsRepository.save(post);
	}
	public List<Posts> getAllPosts(){
		return postsRepository.findAll();
	}
	public Posts getPost(int id) {
		Optional<Posts> optional=postsRepository.findById(id);
		Posts post=null;
		if(optional.isPresent()) {
			post=optional.get();
		}
		return post;
	}
	public Posts updatePost(Posts post,int id) {
		Optional<Posts> optional=postsRepository.findById(id);
		if(optional.isPresent()) {
			post.setId(id);
		}
		return postsRepository.save(post);
	}
	public void deletePost(int id) {
		postsRepository.deleteById(id);
	}
	public List<Posts> getPostByUserId(int userId)
	{
		return postsRepository.findByUserId(userId);
	}
}
