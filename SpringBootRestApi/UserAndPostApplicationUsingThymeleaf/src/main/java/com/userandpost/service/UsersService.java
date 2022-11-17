package com.userandpost.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userandpost.model.Posts;
import com.userandpost.model.Response;
import com.userandpost.model.Users;
import com.userandpost.repository.PostsRepository;
import com.userandpost.repository.UserRepository;
//Service class
@Service
public class UsersService {

	@Autowired
	UserRepository userRepo;//Injecting user reposiotry dependency
	@Autowired
	PostsRepository postsRepo;//Injecting posts reposiotry dependency
	private RestTemplate template;
	//construtor with resttemplte 
	public UsersService(RestTemplate template) {
		super();
		this.template = template;
	}
	//This method insert user in db
	public List<Users> insertUsers(){
		//external users url
		String url="https://jsonplaceholder.typicode.com/users";
		//Using Resttemplate calling the api's amd saving array's
		Users[] response=template.getForObject(url,Users[].class);
		List<Users> userList=Arrays.asList(response);
		//Iterating list
		for(Users u:userList) {
			userRepo.save(u);//save the user data in database
		}
		return userList;
	}
	//This method insert posts in db
	public List<Posts> insertPosts() {
		//extenral posts url
		String posturl="https://jsonplaceholder.typicode.com/posts";
		HttpEntity<Posts> postentity=new HttpEntity<Posts>(null,null);
		//Using Resttemplate calling the api's and saving array
		ResponseEntity<Posts[]> postRes=template.exchange(posturl,HttpMethod.GET,postentity,Posts[].class);
		Posts[] posts = postRes.getBody();
		List<Posts>postList= Arrays.asList(posts);//converting arrays to list
		for(Posts p:postList) {
			postsRepo.save(p);//save the post detils in db
		}
		return postList;
	}
	//This method getting the userdetails using company name
	public List<Users> getUsersByPosts(String companyname){
		return userRepo.findByCompanyName(companyname);
	}
	public List<Posts>getPostsByUserId(int userid){
		return postsRepo.findByUserId(userid);
	}
	//this method getting the all userdetails
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	//this method getting the all post details
	public List<Posts> getAllPosts(){
		return postsRepo.findAll();
	}
	//this method getting user details with posts count
	public List<Response>getPostCount(){
		int count=0;
		List<Response> responseList=new ArrayList<Response>();
		List<Users> userList=this.getAllUsers();
		List<Posts> postList=this.getAllPosts();
		for(Users u:userList) {
			for(Posts p:postList) {
				if(u.getId()==p.getUserId()) 
					count+=1;
				}
				Response response=new Response(u.getId(),u.getName(),count);
				responseList.add(response);
				count=0;
		}
		return responseList;
	}
}
