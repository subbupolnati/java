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

import com.bloodbank.model.Donor;
import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.model.Role;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;
import com.bloodbank.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private DonorService donorService;
	@Autowired
	private PatientService patientService;
	@RequestMapping("/home")
	public String homepage() {
		return "home";
	}
	@RequestMapping("/")
	public String Loginpage() {
		return "loginPage";
	}
	@PostMapping("/logincheck")
	public String loginCheck(@RequestParam("username") String username,@RequestParam("password")String password,@RequestParam("role")String role,Model m) {
		if(username.equals("admin")&& password.equalsIgnoreCase("admin")&& role.equalsIgnoreCase("Admin")) {
			return "home";
		}
		else if(role.equalsIgnoreCase("Donor")) {
			Donor d=donorService.validate(username, password);
			if(d!=null) {
				return "redirect:newblood";
			}
			else {
				m.addAttribute("msg","invalid details");
				return "loginPage";
			}
		}
		else if(role.equalsIgnoreCase("Patient")) {
			Patient p=patientService.validate(username, password);
			if(p!=null) {
				return "redirect:neworder";
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
	public String rolePage(Model m) {
		m.addAttribute("role",new Role());
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList",permissionList);
		return "roleRegister";
	}
	@PostMapping("/saverole")
	public String insertRole(@ModelAttribute("role") Role role,Model m) {
		roleService.addRole(role);
		m.addAttribute("msg","role Successfully added");
		return "roleRegister";
	}
	@RequestMapping("/viewroles")
	public String viewRoles(Model m) {
		List<Role> roleList=roleService.getAllRoles();
		m.addAttribute("roleList", roleList);
		return "viewRoles";
	}
	@RequestMapping("/updateRole/{id}")
	public String updateRole(@PathVariable("id") int id,Model m) {
		Role role=roleService.updateRole(id);
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList",permissionList);
		m.addAttribute("role", role);
		return "roleRegister";
	}
	@RequestMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable("id") int id,Model m) {
		roleService.deleteRole(id);
		List<Role> roleList=roleService.getAllRoles();
		m.addAttribute("roleList", roleList);
		return "viewRoles";
	}
	@RequestMapping("/searchRole")
	public String SearchRole(@RequestParam("id") int id,Model m) {
		List<Role>roleList=roleService.searchRole(id);
		if(roleList.isEmpty()) {
			m.addAttribute("message", "No data found");
			return "viewRoles";
		}
		m.addAttribute("roleList", roleList);
		return "viewRoles";
	}
	@RequestMapping("/logout")
	public String logout(Model m){
		m.addAttribute("msg","Logout Successfully");
		return "loginPage";
	}
}
