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
import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.model.Supplier;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService ss;
	@Autowired
	private PermissionService ps;
	
	@RequestMapping("/newsupplier")
	public String addSupplier(Model m) {
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("supplier",new Supplier());
		m.addAttribute("role","Admin");
		return "SupplierRegister";
	}
	@PostMapping("/savesupplier")
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier,Model m) {
		ss.addSupplier(supplier);
		m.addAttribute("msg","supplier added");
		return "redirect:newsupplier";
	}
	@RequestMapping("/viewsuppliers")
	public String getAllSupplier(Model m) {
		List<Supplier> supplierList=ss.getAllSupplier();
		if(supplierList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("supplierList",supplierList);
		}
		return "viewSupplier";
	}
	@PostMapping("/searchSupplier")
	public String searchSupplier(@RequestParam("id") int id,Model m) {
		List<Supplier> supplierList=ss.getAllSupplier();
		if(supplierList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("supplierList",supplierList);
		}
		return "viewSupplier";
	}
	@RequestMapping("/updatesupplier/{id}")
	public String updateSupplier(@PathVariable("id")int id,Model m) {
		m.addAttribute("supplier",ss.editSupplier(id));
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("msg", "updated successfully");
		return "SupplierRegister";
	}
	@RequestMapping("/deletesupplier/{id}")
	public String deleteSupplier(@PathVariable("id") int id,Model m) {
		List<Supplier> supplierList=ss.getAllSupplier();
		m.addAttribute("supplierList",supplierList);
		return "viewSupplier";
	}
}
