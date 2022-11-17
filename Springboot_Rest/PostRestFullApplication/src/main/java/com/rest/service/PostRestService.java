package com.rest.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.rest.model.Posts;

@Service
public class PostRestService {

	private RestTemplate template;//importing RestTemplate
	//Getter and setter methods
	public RestTemplate getTemplate() {
		return template;
	}
	public void setTemplate(RestTemplate template) {
		this.template = template;
	}
	//This is Argument constructor using RestTemplate parameter
	public PostRestService(RestTemplate template) {
		super();
		this.template = template;
	}
	//This method used to searching particular post based on id
	public ResponseEntity<Posts> searchPost(int id){
		String url="https://jsonplaceholder.typicode.com/posts/"+id;
		ResponseEntity<Posts> entity=template.getForEntity(url,Posts.class);
		Posts post=entity.getBody();
		return entity;
	}
	//This method fetch the all posts data
	public ResponseEntity<Posts[]> showAllPosts(){
		String url="https://jsonplaceholder.typicode.com/posts";
		HttpEntity<Posts> entity=new HttpEntity<Posts>(null,null);
		ResponseEntity<Posts[]> response=template.exchange(url,HttpMethod.GET,entity,Posts[].class);
		return response;
	}
	//This method insert the new post
	public ResponseEntity<Posts> insertNewPost(Posts post) throws URISyntaxException{
		URI uri=new URI("https://jsonplaceholder.typicode.com/posts");
		//String url="https://jsonplaceholder.typicode.com/posts";
		HttpEntity<Posts> entity=new HttpEntity<Posts>(post,null);
		ResponseEntity<Posts> response=template.postForEntity(uri,entity,Posts.class);
		return response;
	}
	//This method updated the existing post using postId
	public ResponseEntity<Posts> updatePostById(int id,Posts post){
		String url="https://jsonplaceholder.typicode.com/posts/"+id;
		HttpEntity<Posts> entity=new HttpEntity<Posts>(post,null);
		ResponseEntity<Posts> response=template.exchange(url,HttpMethod.PUT,entity,Posts.class);
		return response;
	}
	//This method delete the existing post using postId
	public ResponseEntity<Posts> DeletePostById(int id) throws URISyntaxException{
		URI uri=new URI("https://jsonplaceholder.typicode.com/posts/"+id);
		HttpEntity<Posts> entity=new HttpEntity<Posts>(null,null);
		ResponseEntity<Posts> response=template.exchange(uri,HttpMethod.DELETE,entity,Posts.class);
		return response;
	}
}
