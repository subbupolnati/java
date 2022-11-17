package com.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.model.Role;
import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.RoleService;
import com.inventorymanagementsystem.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private PermissionService ps;
	@Autowired
	private RoleService rs;
	
	@RequestMapping("/newuser")
	public String addUser(Model m) {
		m.addAttribute("user",new User());
		List<Role> roleList=rs.getAllRole();
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("roleList", roleList);
		return "UserRegister";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user")User user,Model m) {
		us.addUser(user);
		m.addAttribute("msg","user added successfully");
		return "redirect:newuser";
	}
	@RequestMapping("/viewusers")
	public String getAllUsers(Model m) {
		List<User> userList=us.getAllUser();
		if(userList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("userList", userList);
		}
			return "viewUsers";
	}
	@PostMapping("/searchuser")
	public String searchUser(@RequestParam("id") int id,Model m) {
		List<User> userList=us.searchUser(id);
		if(userList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("userList", userList);
		}
		return "viewUser";
	}
	@RequestMapping("/updateuser/{id}")
	public String updateUser(@PathVariable("id")int id,Model m) {
		m.addAttribute("user",us.editUser(id));
		List<Role> roleList=rs.getAllRole();
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("roleList", roleList);
		//m.addAttribute("msg", "updated successfully");
		return "UserRegister";
	}
	@RequestMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id,Model m) {
		us.deleteUser(id);
		List<User> userList=us.getAllUser();
		m.addAttribute("userList",userList);
		return "viewUsers";
	}
}
