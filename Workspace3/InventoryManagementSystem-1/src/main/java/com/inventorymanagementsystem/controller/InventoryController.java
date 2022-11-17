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
import com.inventorymanagementsystem.model.Inventory;
import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.model.Stock;
import com.inventorymanagementsystem.service.InventoryService;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.StockService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService is;
	@Autowired
	PermissionService ps;
	@Autowired
	StockService ss;
	
	@RequestMapping("/newInventory")
	public String addInventory(Model m) {
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList",permissionList);
		m.addAttribute("inventory",new Inventory());
		return "InventoryRegister";
	}
	@PostMapping("/saveinventory")
	public String saveInventory(@ModelAttribute("inventory")Inventory inventory,Model m) {
		is.addInventory(inventory);
		Stock stock=new Stock();
		stock.setStockid(inventory.getInventoryid());
		stock.setStocktype(inventory.getInventorytype());
		stock.setStockitems(inventory.getInventoryitems());
		stock.setStockdescription(inventory.getInvventorydescription());
		stock.setStocknumber(inventory.getInventorynumber());
		stock.setPermission(inventory.getPermission());
		ss.addStock(stock);
		return "redirect:newInventory";
	}
	@RequestMapping("/viewInventory")
	public String getAllInventrory(Model m) {
		List<Inventory> inventoryList=is.getAllInventory();
		if(inventoryList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("inventoryList",inventoryList);
		}
		return "viewInventory";
	}
	@PostMapping("/searchinventory")
	public String searchInventory(@RequestParam("id") int id,Model m) {
		List<Inventory> inventoryList=is.getAllInventory();
		if(inventoryList.isEmpty()) {
			m.addAttribute("message","No data avalible");
		}
		else {
			m.addAttribute("inventoryList",inventoryList);
		}
		return "viewInventory";
	}
	@RequestMapping("/updateinventory/{id}")
	public String updateInventory(@PathVariable("id")int id,Model m) {
		m.addAttribute("inventory",is.editInventory(id));
		List<Permission> permissionList=ps.getPermissions();
		m.addAttribute("permissionList", permissionList);
		m.addAttribute("msg", "updated successfully");
		return "InventoryRegister";
	}
	@RequestMapping("/deleteinventory/{id}")
	public String deleteInventory(@PathVariable("id") int id,Model m) {
		is.deleteInventory(id);
		List<Inventory> inventoryList=is.getAllInventory();
		m.addAttribute("inventoryList",inventoryList);
		return "viewInventory";
	}
}
