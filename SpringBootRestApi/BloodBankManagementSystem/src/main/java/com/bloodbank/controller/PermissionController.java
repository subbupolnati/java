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

import com.bloodbank.model.Permission;
import com.bloodbank.service.PermissionService;

@Controller
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	@RequestMapping("/newpermission")
	public String createPermission(Model m) {
		m.addAttribute("permission",new Permission());
		return "PermissionRegister";
	}
	@PostMapping("/savepermission")
	public String insertPermission(@ModelAttribute("permission")Permission permission,Model m) {
		permissionService.addPermission(permission);
		m.addAttribute("msg", "Permission successfully added");
		return "redirect:newpermission";
	}
	@RequestMapping("/getAllPermission")
	public String getAllPermissions(Model m){
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList", permissionList);
		return "viewPermission";
	}
	@RequestMapping("/updatepermission/{id}")
	public String updatePermission(@PathVariable("id")int id,Model m) {
		m.addAttribute("permission",permissionService.updatePermission(id));
		m.addAttribute("msg", "updated successfully");
		return "PermissionRegister";
	}
	@RequestMapping("/deletepermission/{id}")
	public String deletePermission(@PathVariable("id") int id,Model m) {
		permissionService.deletPermission(id);
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList", permissionList);
		return "viewPermission";
	}
	@RequestMapping("/searchPermission")
	public String searchPermission(@RequestParam("id") int id,Model m) {
		List<Permission> permissionList=permissionService.searchPermission(id);
		if(permissionList.isEmpty()) {
			m.addAttribute("message","No data found");
			return "viewPermission";
		}
		m.addAttribute("permissionList", permissionList);
		return "viewPermission";
	}
}
