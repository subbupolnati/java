package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodbank.model.Role;
import com.bloodbank.model.User;
import com.bloodbank.service.RoleService;
import com.bloodbank.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/newuser")
	public String createUser(Model m) {
		m.addAttribute("user",new User());
		List<Role>roleList=roleService.getAllRoles();
		m.addAttribute("roleList", roleList);
		return "userRegister";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") User user,Model m) {
		userService.addUser(user);
		m.addAttribute("msg","userRegistered successfully");
		return "userRegister";
	}
	@RequestMapping("/viewusers")
	public String viewAllUsers(Model m){
		List<User> userList=userService.getAllUser();
		m.addAttribute("userList", userList);
		return "viewUsers";
	}
	@RequestMapping("/updateuser/{id}")
	public String updateUser(@PathVariable("id") int id,Model m) {
		m.addAttribute("user",userService.updateUser(id));
		List<Role>roleList=roleService.getAllRoles();
		m.addAttribute("roleList", roleList);
		m.addAttribute("msg","succesfully updated");
		return "userRegister";
	}
	@RequestMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id,Model m) {
		userService.deleteUser(id);
		List<User> userList=userService.getAllUser();
		m.addAttribute("userList", userList);
		return "viewUsers";
	}
	@RequestMapping("/searchuser")
	public String searchUser(@RequestParam("id") int id,Model m) {
		List<User> userList=userService.searchUser(id);
		if(userList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewUsers";
		}
		m.addAttribute("userList", userList);
		return "viewUsers";
	}
}
