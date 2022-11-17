package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.model.Customer;
import com.inventory.model.Inventory;
import com.inventory.model.Permission;
import com.inventory.model.Role;
import com.inventory.model.Stock;
import com.inventory.model.Supplier;
import com.inventory.model.User;
import com.inventory.service.CustomerService;
import com.inventory.service.PermissionService;
import com.inventory.service.RoleService;
import com.inventory.service.SupplierService;
import com.inventory.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	@Autowired
	private SupplierService ss;
	@Autowired
	private PermissionService ps;
	@Autowired
	private CustomerService cs;
	public static String token;
	public static String getToken() {
		return token;
	}
	public static void setToken(String token) {
		UserController.token = token;
	}
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/")
	public String loginpage() {
		return "loginPage";
	}
	@RequestMapping("/logout")
	public String logOut() {
		//token=null;
		return "loginPage";
	}
	@RequestMapping("/newuser")
	public String addUser(Model m) {
		m.addAttribute("user",new User());
		List<Role> roleList=rs.getAllRoles();
		m.addAttribute("roleList", roleList);
		return "UserRegister";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user")User user,Model m) {
		us.addUser(user);
		m.addAttribute("msg","user added successfully");
		return "redirect:newuser";
	}

	
	//signup after login details
	@PostMapping("/signin")
	public String generateToken(@ModelAttribute("user") User user,Model m){
		User u=us.validate(user.getUsername());
		System.out.println(u.getUsername());
		if(u.equals(null)){
			m.addAttribute("msg","please register user");
			return "loginPage";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Boolean status=encoder.matches(user.getPassword(),u.getPassword());//matches the raw password and encrypt password
		if(u.getUsername()!=user.getUsername()&&status==false){
			m.addAttribute("msg","Invalid password and username");
			return "loginPage";
		}
		else {
			token=us.getTokenResponse(user);
			//System.out.println("user details"+user);
			if(user.getUserrole().getRoletitle().equalsIgnoreCase("ROLE_Admin")){
				return "home";
			}
			else if(user.getUserrole().getRoletitle().equalsIgnoreCase("ROLE_Supplier")) {
				Supplier s=ss.validate(user.getUsername());
				if(s==null) {
					List<Permission>permissionList=ps.getAllPermissions();
					m.addAttribute("permissionList",permissionList);
					m.addAttribute("supplier",new Supplier());
					return "SupplierRegister";
				}
				List<Permission>permissionList=ps.getAllPermissions();
				m.addAttribute("permissionList",permissionList);
				m.addAttribute("inventory",new Inventory());
				return "InventoryRegister";
			}
			else if(user.getUserrole().getRoletitle().equalsIgnoreCase("ROLE_Customer")){
				Customer c=cs.validate(user.getUsername());
				if(c==null) {
					List<Permission>permissionList=ps.getAllPermissions();
					m.addAttribute("permissionList",permissionList);
					m.addAttribute("Customer",new Customer());
					return "CustomerRegister";
				}
				List<Permission>permissionList=ps.getAllPermissions();
				m.addAttribute("permissionList",permissionList);
				m.addAttribute("Stock",new Stock());
				return "StockRegister";
			}
		}
		return "loginPage";
	}
}