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

import com.inventory.model.Payment;
import com.inventory.model.Permission;
import com.inventory.service.PaymentService;
import com.inventory.service.PermissionService;

@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("/newpayment")
	public String addPayment(Model m) {
		m.addAttribute("payment",new Payment());
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList", permissionList);
		return "PaymentRegister";
	}
	@PostMapping("/savePayment")
	public String savePayment(@ModelAttribute("payment") Payment payment,Model m) {
		paymentService.addPayment(payment);
		m.addAttribute("msg","payment Successfully completed");
		return "success";
	}
	@RequestMapping("/viewpayments")
	public String getAllPayments(Model m) {
		List<Payment> paymentList=paymentService.getAllPayments();
		if(paymentList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("paymentList",paymentList);
		}
		return "viewPayment";
	}
	/*@PostMapping("/searchPayment")
	public String searchPayment(@RequestParam("id") int id,Model m) {
		List<Payment>paymentList=paymentService.searchPayment(id);
		if(paymentList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("paymentList",paymentList);
		}
		return "viewPayment";
	}
	@RequestMapping("/updatepayment/{id}")
	public String updatePayment(@PathVariable("id")int id,Model m) {
		m.addAttribute("payment",paymentService.editPayment(id));
		List<Permission> permissionList=permissionService.getAllPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("msg", "updated successfully");
		return "PaymentRegister";
	}
	@RequestMapping("/deletepayment/{id}")
	public String deletePayment(@PathVariable("id") int id,Model m) {
		paymentService.deletePayment(id);
		List<Payment> paymentList=paymentService.getAllPayments();
		m.addAttribute("paymentList",paymentList);
		return "viewPayment";
	}*/
}
