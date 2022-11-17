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
import com.inventorymanagementsystem.service.CustomerService;
import com.inventorymanagementsystem.service.PermissionService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cs;
	@Autowired
	private PermissionService ps;
	@RequestMapping("/newCustomer")
	public String addCustomer(Model m) {
		m.addAttribute("customer",new Customer());
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		return "CustomerRegister";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer,Model m){
		cs.addCustomer(customer);
		m.addAttribute("msg","Customer added");
		return "redirect:newCustomer";
	}
	@RequestMapping("/viewCustomers")
	public String getAllCustomers(Model m) {
		List<Customer> customerList=cs.getAllCustomer();
		if(customerList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("customerList", customerList);
		}
		return "viewCustomer";
	}
	@PostMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("id") int id,Model m) {
		List<Customer> customerList=cs.searchCustomer(id);
		if(customerList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("customerList",customerList);
		}
		return "viewCustomer";
	}
	@RequestMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id")int id,Model m) {
		m.addAttribute("customer",cs.editCustomer(id));
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("msg", "updated successfully");
		return "CustomerRegister";
	}
	@RequestMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id,Model m) {
		cs.deleteCustomer(id);
		List<Customer> customerList=cs.getAllCustomer();
		m.addAttribute("customerList",customerList);
		return "viewCustomer";
	}
}
