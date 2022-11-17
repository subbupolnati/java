package com.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.rest.model.Posts;
import com.rest.model.Response;
import com.rest.model.User;

@Service
public class RestService {
	
	RestTemplate template;

	public RestService(RestTemplate template) {
		super();
		this.template = template;
	}
	
	public List<Response>getResponse(){
		List<Response>responseList=new ArrayList<Response>();
		String userurl="https://jsonplaceholder.typicode.com/users";
		HttpEntity<User> entity=new HttpEntity<User>(null,null);
		ResponseEntity<User[]> userRes=template.exchange(userurl,HttpMethod.GET,entity,User[].class);
		User[] users = userRes.getBody();
		List<User>userList= Arrays.asList(users);
		System.out.println(userList);
		String posturl="https://jsonplaceholder.typicode.com/posts";
		HttpEntity<Posts> postentity=new HttpEntity<Posts>(null,null);
		ResponseEntity<Posts[]> postRes=template.exchange(posturl,HttpMethod.GET,postentity,Posts[].class);
		Posts[] posts = postRes.getBody();
		List<Posts>postList= Arrays.asList(posts);
		System.out.println(postList);
		
		for(User user:userList) {
			for(Posts post:postList) {
				
				if(user.getId()==post.getId()) {
					Response response=new Response();
					response.setCompany_name(user.getCompany().getName());
					response.setTitle(post.getTitle());
					response.setBody(post.getBody());
					responseList.add(response);
				}
			}
		}
		return responseList;
	}
	public List<Posts>getAllPosts(){
		String url="https://jsonplaceholder.typicode.com/posts";
		Posts[] post=template.getForObject(url,Posts[].class);
		System.out.println(post.toString());
		return Arrays.asList(post);
	}
}
