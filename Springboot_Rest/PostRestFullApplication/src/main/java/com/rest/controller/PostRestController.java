package com.rest.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.Posts;
import com.rest.service.PostRestService;
//This class used to controller perform business logic
@RestController
public class PostRestController {

	@Autowired
	PostRestService postRestService;//injecting the dependency 
	//This url is used to fetch post by using postId
	@GetMapping("/post/{id}")
	public ResponseEntity<Posts> searchPostById(@PathVariable("id") int id){
		return postRestService.searchPost(id);
	}
	//This url is used to insert new post 
	@PostMapping("/post")
	public ResponseEntity<Posts> insertNewPost(@RequestBody Posts post) throws URISyntaxException{
		return postRestService.insertNewPost(post);
	}
	//This url is used to show all Posts
	@GetMapping("/post")
	public ResponseEntity<Posts[]> showAllPosts(){
		return postRestService.showAllPosts();
	}
	//This url is used to update the posts by postId
	@PutMapping("/post/{id}")
	public ResponseEntity<Posts>updatePostById(@PathVariable("id") int id,@RequestBody Posts post){
		return postRestService.updatePostById(id, post);
	}
	//This url is used delete post by postId
	@DeleteMapping("/post/{id}")
	public ResponseEntity<Posts>deletePostById(@PathVariable("id") int id) throws URISyntaxException{
		return postRestService.DeletePostById(id);
	}
}
