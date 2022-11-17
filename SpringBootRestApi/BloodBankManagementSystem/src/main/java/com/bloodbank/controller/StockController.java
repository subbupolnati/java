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
import com.bloodbank.model.Permission;
import com.bloodbank.model.Stock;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.PermissionService;
import com.bloodbank.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/newstock")
	public String createStock(Model m) {
		m.addAttribute("stock",new Stock());
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("permissionList", plist);
		return "StockRegister";
	}
	@PostMapping("/savestock")
	public String saveDonor(@ModelAttribute("stock") Stock stock,Model m) {
		stockService.addStock(stock);
		m.addAttribute("msg","stock added successfully");
		return "StockRegister";
	}
	@RequestMapping("/viewstocks")
	public String viewStocks(Model m) {
		List<Stock> stockList=stockService.getAllStocks();
		m.addAttribute("stockList", stockList);
		return "viewStocks";
	}
	@RequestMapping("/updatestock/{id}")
	public String updateStock(@PathVariable("id")int id,Model m) {
		m.addAttribute("stock",stockService.updateStock(id));
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("permissionList", plist);
		m.addAttribute("msg","stock successfully added");
		return "StockRegister";
	}
	@RequestMapping("/deletestock/{id}")
	public String deleteStock(@PathVariable("id") int id,Model m) {
		stockService.deleteStock(id);
		List<Stock> stockList=stockService.getAllStocks();
		m.addAttribute("stockList", stockList);
		return "viewStocks";
	}
	@RequestMapping("/searchstock")
	public String searchDonor(@RequestParam("id") String id,Model m) {
		List<Stock> stockList=stockService.searchStocks(id);
		if(stockList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewStocks";
		}
		m.addAttribute("stockList", stockList);
		return "viewStocks";
		
	}
}
