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

import com.inventorymanagementsystem.model.Customer;
import com.inventorymanagementsystem.model.Role;
import com.inventorymanagementsystem.model.Supplier;
import com.inventorymanagementsystem.service.CustomerService;
import com.inventorymanagementsystem.service.RoleService;
import com.inventorymanagementsystem.service.SupplierService;

@Controller
public class RoleController {

	@Autowired
	private RoleService rs;
	@Autowired
	private SupplierService ss;
	@Autowired
	private CustomerService cs;
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/")
	public String Loginpage() {
		return "loginPage";
	}
	@PostMapping("/logincheck")
	public String loginCheck(@RequestParam("username") String username,@RequestParam("password")String password,@RequestParam("role")String role,Model m) {
		if(username.equals("admin")&& password.equalsIgnoreCase("admin")&& role.equalsIgnoreCase("Admin")) {
			m.addAttribute("role",role);
			return "home";
		}
		else if(role.equalsIgnoreCase("Supplier")) {
			Supplier s=ss.validate(username, password);
			if(s!=null) {
				m.addAttribute("role",role);
				m.addAttribute("username",username);
				return "redirect:newInventory";
			}
			else {
				m.addAttribute("msg","invalid details");
				return "loginPage";
			}
		}
		else if(role.equalsIgnoreCase("Customer")) {
			Customer c =cs.validate(username, password);
			if(c!=null) {
				m.addAttribute("role",role);
				m.addAttribute("username",username);
				return "redirect:viewstock";
			}
			else {
				m.addAttribute("msg","invalid details");
				return "loginPage";
			}
		}
		m.addAttribute("msg","invalid details");
		return "loginPage";
	}
	@RequestMapping("/newrole")
	public String addRole(Model m) {
		m.addAttribute("role",new Role());
		return "roleRegister";
	}
	@PostMapping("/saverole")
	public String saveRole(@ModelAttribute("role")Role role,Model m) {
		rs.addRole(role);
		m.addAttribute("msg", "role successfully added");
		return "redirect:newrole";
	}
	@RequestMapping("/viewroles")
	public String getRoles(Model m) {
		List<Role> roleList=rs.getAllRole();
		if(roleList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("roleList", roleList);
		}
		return "viewRoles";
	}
	@PostMapping("/searchRole")
	public String searchRole(@RequestParam("id") int id,Model m) {
		List<Role> roleList=rs.searchRole(id);
		if(roleList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("roleList", roleList);
		}
		return "viewRoles";
	}
	@RequestMapping("/updateRole/{id}")
	public String updateRole(@PathVariable("id")int id,Model m) {
		m.addAttribute("role",rs.editRole(id));
		m.addAttribute("msg", "updated successfully");
		return "roleRegister";
	}
	@RequestMapping("/deleterole/{id}")
	public String deleteRole(@PathVariable("id") int id,Model m) {
		rs.deleteRole(id);
		List<Role> roleList=rs.getAllRole();
		m.addAttribute("roleList", roleList);
		return "viewRoles";
	}
}
