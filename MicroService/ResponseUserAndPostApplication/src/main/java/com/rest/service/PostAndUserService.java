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
public class PostAndUserService {

	private RestTemplate restTemplate;//create reference of RestTemplate 
	//Argument constructor  
	public PostAndUserService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	final String userurl="https://jsonplaceholder.typicode.com/users";//This is User url
	final String posturl="https://jsonplaceholder.typicode.com/posts";//This is Post url
	List<Response>responseList;
	
	
	//This Method perform response creating operations
	public List<Response>getResponse(){
		return responseList=compareUserAndPostLists();
	}
	//This Method perform getting to userList return List of users 
	public List<User> getUsersList(){
		HttpEntity<User> userEntity=new HttpEntity<User>(null,null);
		//get and store the userResponse in user class using rest template  exchange method
		ResponseEntity<User[]> userResponse=restTemplate.exchange(userurl,HttpMethod.GET,userEntity,User[].class);
		User[] users = userResponse.getBody();//store data in user class 
		List<User>userList= Arrays.asList(users);//convert to arrays into list
		return userList;
	}
	//This Method perform getting to postList return List of posts 
	public List<Posts> getPostsList(){
		HttpEntity<Posts> postEntity=new HttpEntity<Posts>(null,null);
		//get and store the post Response in posts class using rest template  exchange method
		ResponseEntity<Posts[]> postResponse=restTemplate.exchange(posturl,HttpMethod.GET,postEntity,Posts[].class);
		Posts[] posts = postResponse.getBody();//store data in posts class 
		List<Posts>postList= Arrays.asList(posts);//convert to arrays into list
		return postList;
	}
	//This Method perform compare two lists return Response
	public List<Response> compareUserAndPostLists(){
		responseList=new ArrayList<Response>();//create response Array List
		List<User> userList=getUsersList();
		List<Posts> postList=getPostsList();
		//Iterating  user list and post list
		for(User user:userList){
			for(Posts post:postList){
				if(user.getId()==post.getId()){//this condition checks user class id and post class id
					Response response=new Response();//creating object to Response class
					response.setLat(user.getAddress().getGeo().getLat());//set latitude value using setter method
					response.setLng(user.getAddress().getGeo().getLng());//set lng value using setter method
					response.setCompany_name(user.getCompany().getName());//set companyName value using setter method
					response.setTitle(post.getTitle());//set title value using setter method
					response.setBody(post.getBody());//set body value using setter method
					responseList.add(response);//add the data into list
				}
			}
		}
		return responseList;
	}
}
