package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.model.Customer;
import com.inventory.model.Role;
import com.inventory.model.Supplier;
import com.inventory.service.CustomerService;
import com.inventory.service.RoleService;
import com.inventory.service.SupplierService;

@Controller
public class RoleController {

	@Autowired
	private RoleService rs;
	@Autowired
	private SupplierService ss;

	@RequestMapping("/newrole")
	public String addRole(Model m) {
		m.addAttribute("role",new Role());
		return "roleRegister";
	}
	@PostMapping("/saverole")
	public String saveRole(@ModelAttribute("role")Role role,Model m) {
		rs.addnewRole(role);
		m.addAttribute("msg", "role successfully added");
		return "redirect:newrole";
	}
	@RequestMapping("/viewroles")
	public String getRoles(Model m) {
		List<Role> roleList=rs.getAllRoles();
		if(roleList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("roleList", roleList);
		}
		return "viewRoles";
	}
	/*@PostMapping("/searchRole")
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
		List<Role> roleList=rs.getAllRoles();
		m.addAttribute("roleList", roleList);
		return "viewRoles";
	}*/
}
