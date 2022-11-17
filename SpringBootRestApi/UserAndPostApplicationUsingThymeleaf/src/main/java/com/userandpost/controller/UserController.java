package com.userandpost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.userandpost.model.Posts;
import com.userandpost.model.Response;
import com.userandpost.model.Users;
import com.userandpost.service.UsersService;
//This class Perform Controller
@Controller
public class UserController {
	
	@Autowired
	private UsersService userService;//Injecting the UserService dependency 
	//This Url insert and getting userList
	@GetMapping("/users")
	public String usersList(Model m){
		List<Users> userList=userService.insertUsers();
		m.addAttribute("user", userList);
		return "users";
		
	}
	//This Url insert and getting post details
	@GetMapping("/posts")
	public String postList(Model m){
		List<Posts>postList= userService.insertPosts();
		m.addAttribute("posts", postList);
		return "posts";
	}
	//This Url getting the userdetails by company name
	@RequestMapping("/users/companyname")
	public String getUserByCompanyName(@RequestParam("companyname")String comapanyname,Model m){
		List<Users> ulist= userService.getUsersByPosts(comapanyname);
		m.addAttribute("user",ulist);
		return "users";
	}
	//This url getting the userdatails with post count
	@GetMapping("/users/postcount")
	public String getResponse(Model m){
		List<Response> rlist= userService.getPostCount();
		m.addAttribute("res",rlist);
		return "Response";
	}
	@RequestMapping("/post/userid")
	public String getPostByUserId(@RequestParam("userid")int userid,Model m){
		List<Posts> plist= userService.getPostsByUserId(userid);
		m.addAttribute("posts",plist);
		return "posts";
	}
}
