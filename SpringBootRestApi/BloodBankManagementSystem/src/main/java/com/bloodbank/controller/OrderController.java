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

import com.bloodbank.model.Order;
import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.service.OrderService;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/neworder")
	public String createOrder(Model m) {
		m.addAttribute("order",new Order());
		List<Permission> plist=permissionService.getAllPermissions();
		List<Patient> patientList=patientService.getAllpatients();
		m.addAttribute("permissionList", plist);
		m.addAttribute("patientList", patientList);
		return "OrderRegister";
	}
	@PostMapping("/saveorder")
	public String saveOrder(@ModelAttribute("order") Order order,Model m) {
		orderService.addOrder(order);
		m.addAttribute("msg"," Order successfully completed");
		return "OrderRegister";
	}
	@RequestMapping("/vieworders")
	public String viewOrders(Model m) {
		List<Order> orderList=orderService.getAllOrders();
		m.addAttribute("orderList", orderList);
		return "viewOrders";
	}
	@RequestMapping("/updateorder/{id}")
	public String updateOrder(@PathVariable("id")int id,Model m) {
		List<Permission> plist=permissionService.getAllPermissions();
		List<Patient> patientList=patientService.getAllpatients();
		m.addAttribute("order",orderService.updateOrder(id));
		m.addAttribute("permissionList", plist);
		m.addAttribute("patientList", patientList);
		return "OrderRegister";
	}
	@RequestMapping("/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") int id,Model m) {
		orderService.deletOrder(id);
		List<Order> orderList=orderService.getAllOrders();
		m.addAttribute("orderList", orderList);
		return "viewOrders";
	}
	@RequestMapping("/searchOrder")
	public String searchOrder(@RequestParam("id") int id,Model m) {
		List<Order> orderList=orderService.searchOrder(id);
		if(orderList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewOrders";
		}
		
		m.addAttribute("orderList", orderList);
		return "viewOrders";
	}
}
