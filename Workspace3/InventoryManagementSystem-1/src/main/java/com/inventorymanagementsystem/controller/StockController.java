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

import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.model.Stock;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.StockService;

@Controller
public class StockController {
	@Autowired
	StockService ss;
	@Autowired
	private PermissionService ps;
	
	@RequestMapping("/newstock")
	public String addStock(Model m) {
		m.addAttribute("stock",new Stock());
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		return "StockRegister";
	}
	@PostMapping("/savestock")
	public String saveStock(@ModelAttribute("stock") Stock stock,Model m){
		ss.addStock(stock);
		m.addAttribute("msg","Stock added");
		return "redirect:newstock";
	}
	@RequestMapping("/viewstocks")
	public String getAllStock(Model m) {
		List<Stock> stockList=ss.getAllStock();
		if(stockList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("stockList",stockList);
		}
		return "viewStocks";
	}
	@RequestMapping("/viewstock")
	public String getAllStocks(Model m) {
		List<Stock> stockList=ss.getAllStock();
		if(stockList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("stockList",stockList);
		}
		return "StocksList";
	}
	@PostMapping("/searchstock")
	public String searchStock(@RequestParam("id") int id,Model m) {
		List<Stock> stockList=ss.searchStock(id);
		if(stockList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("stockList",stockList);
		}
		return "viewStocks";
	}
	@RequestMapping("/updatestock/{id}")
	public String updateStock(@PathVariable("id")int id,Model m) {
		m.addAttribute("stock",ss.editStock(id));
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("msg", "updated successfully");
		return "StockRegister";
	}
	@RequestMapping("/deletestock/{id}")
	public String deleteStock(@PathVariable("id") int id,Model m) {
		ss.deleteStock(id);
		List<Stock> stockList=ss.getAllStock();
		m.addAttribute("stockList",stockList);
		return "viewStocks";
	}
}
