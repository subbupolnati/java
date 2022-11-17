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

import com.inventory.model.Permission;
import com.inventory.service.PermissionService;

@Controller
public class PermissionController {

	@Autowired
	private PermissionService ps;
	
	
	@RequestMapping("/newpermission")
	public String addPermission(Model m) {
		Permission permission=new Permission();
		m.addAttribute("permission",permission);
		return "PermissionRegister";
	}
	@PostMapping("/savepermission")
	public String insertPermission(@ModelAttribute("permission")Permission permission,Model m) {
		ps.addPermission(permission);
		m.addAttribute("msg", "Permission successfully added");
		return "redirect:newpermission";
	}
	@RequestMapping("/getAllPermission")
	public String getPermission(Model m) {
		List<Permission> permissionList=ps.getAllPermissions();
		if(permissionList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("permissionList", permissionList);
		}
		return "viewPermission";
	}
	/*@PostMapping("/searchPermission")
	public String searchPermission(@RequestParam("id") int id,Model m) {
		List<Permission> permissionList=ps.searchPermission(id);
		if(permissionList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("permissionList", permissionList);
		}
		return "viewPermission";
	}
	@RequestMapping("/updatepermission/{id}")
	public String updatePermission(@PathVariable("id")int id,Model m) {
		m.addAttribute("permission",ps.editPermission(id));
		m.addAttribute("msg", "updated successfully");
		return "PermissionRegister";
	}
	@RequestMapping("/deletepermission/{id}")
	public String deletePermission(@PathVariable("id") int id,Model m) {
		ps.deletePermission(id);
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		return "viewPermission";
	}*/
}
