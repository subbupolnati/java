package com.posts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posts.model.Posts;
import com.posts.service.PostService;

@RestController
public class PostsController {

	@Autowired
	PostService postService;
	
	@GetMapping("/post")
	public List<Posts> getAllPosts(){
		return postService.getAllPosts();
	}
	@PostMapping("/post")
	public Posts insertPost(@RequestBody Posts post) {
		return postService.insertPosts(post);
	}
	@GetMapping("/post/{id}")
	public Posts getPost(@PathVariable("id") int id) {
		return postService.getPost(id);
	}
	@PutMapping("/post/{id}")
	public Posts updatePost(@RequestBody Posts post,@PathVariable("id") int id) {
		return postService.updatePost(post, id);
	}
	@DeleteMapping("/post/{id}")
	public void deletePost(@PathVariable("id") int id) {
		postService.deletePost(id);
	}
	@GetMapping("/post/user/{userId}")
	public List<Posts> getPostsByUserId(@PathVariable("userId") int userId){
		return postService.getPostByUserId(userId);
	}
}
