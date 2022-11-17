package com.tweet.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tweet.model.Posts;
import com.tweet.model.Tweets;
import com.tweet.model.User;
import com.tweet.service.PostsService;
import com.tweet.service.TweetService;
import com.tweet.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	TweetService ts;
	
	@Autowired
	PostsService ps;
	User u;
	@RequestMapping("/")
	public String login(Model m) {
		m.addAttribute("user",new User());
		return "login";
	}
	//Checking the credentials
		@RequestMapping("/credentialcheck")
		public String validate(@ModelAttribute("user") User user,Model m,HttpSession session) {
			u=userService.validate(user.getUserName(),user.getPassword());
			session.setAttribute("role",u.getUserName());
			if(u==null) {
				m.addAttribute("msg","Invalid Details");
				return "login";
			}
			else if(user.getRole().equals("admin")) {
				return"adminhome";
			}
			else{
				//session.setAttribute("username",user.getUserName());
				Tweets tweet=ts.getTweets(user.getUserName());
				if(tweet==null) {
					Tweets tweet1=new Tweets();
					tweet1.setUsername(user.getUserName());
					m.addAttribute("tweet",tweet1);
					return "tweetReg";
				}
				List<Posts> p=ps.getAllPosts(user.getUserName());
				m.addAttribute("post",p);
				//m.addAttribute("user", u);
				m.addAttribute("tweet",tweet);
				return "home";
				}
			}
		@GetMapping("/loginregisterpage")
		public String loginpage(Model m) {
			m.addAttribute("user",new User());
			return"credentialRegister";
		}
		@PostMapping("/save")
		public String insertUser(@ModelAttribute("user") User user, Model m) {
			userService.insert(user);
			return "login";
		}
		@PostMapping("/tweetsave")
		public String insertTweets( @ModelAttribute("tweet") Tweets tweet, Model m,final @RequestParam("imagefile") MultipartFile file) throws IOException {
				byte[] byteObjects = file.getBytes();//convertToBytes(file);
				String encodedString = Base64.getEncoder().encodeToString(byteObjects);
				tweet.setImage(encodedString);
				ts.insertNewTweet(tweet);
				return "home";
		}
		@PostMapping("/postsave")
		public String insertPosts( @ModelAttribute("post") Posts post, Model m) {
				ps.insertNewPost(post);
				Tweets t1=ts.updateTweet(post.getUser().getUserName());
				return "redirect:homepage";
		}
		@RequestMapping("/followings/{id}")
		public String updateFollowings(@PathVariable("id") String username,Model m) {
			Tweets t=ts.updateFollowings(username);
			return "redirect:homepage";
		}
		@RequestMapping("/homepage")
		public String homepage(Model m) {
			Tweets tweet=ts.getTweets(u.getUserName());
			List<Posts> p=ps.getAllPosts(u.getUserName());
			m.addAttribute("tweet",tweet);
			m.addAttribute("post",p);
			return "home";

		}
		@RequestMapping("/post/{id}")
		public String addNewPost(@PathVariable("id")String userName, Model m) {
			Posts p=new Posts();
			p.setUser(userService.getUser(userName));
			m.addAttribute("post", p);
			return "postReg";
		}
		@RequestMapping("/changedp/{id}")
		public String changeDp(@PathVariable("id")String userName, Model m) {
			Tweets tweet=new Tweets();
			tweet=ts.getTweets(userName);
			m.addAttribute("tweet",tweet);
			return "updatedp";
		}
		@PostMapping("/changeDpSave")
		public String updateDpSave( @ModelAttribute("tweet") Tweets tweet, Model m,final @RequestParam("imagefile") MultipartFile file) throws IOException {
				byte[] byteObjects = file.getBytes();//convertToBytes(file);
				String encodedString = Base64.getEncoder().encodeToString(byteObjects);
				tweet.setImage(encodedString);
				ts.insertNewTweet(tweet);
				return "redirect:homepage";
		}
		@RequestMapping("/delete/{id}")
		public String deletePost(@PathVariable("id") int id) {
			ps.deletePost(id);
			return "redirect:homepage";
		}
		@RequestMapping("/viewPosts")
		public String viewAllPost(Model m){
			List<Posts> post=ps.viewAllPosts();
			m.addAttribute("post", post);
			return"viewAllPosts";
		}
		@RequestMapping("/viewUsers")
		public String viewAllUsers(Model m){
			List<User> user=userService.getAllUsers();
			m.addAttribute("user", user);
			return"viewAllUsers";
		}
		@RequestMapping("/viewTweets")
		public String viewAllTweets(Model m){
			List<Tweets> tweet=ts.getAllTweets();
			m.addAttribute("tweet", tweet);
			return"viewAllTweets";
		}
		//This Url is navigate to logout page
		@GetMapping("/logout")
		public String logout() {
			return "redirect:/";
		}
}
