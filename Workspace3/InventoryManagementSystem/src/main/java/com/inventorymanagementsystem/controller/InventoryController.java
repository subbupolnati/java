package com.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagementsystem.model.Inventory;
import com.inventorymanagementsystem.service.InventoryService;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.StockService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService is;
	@Autowired
	PermissionService ps;
	@Autowired
	StockService ss;
	
	@PostMapping("/inventory")
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		return is.addInventory(inventory);
	}
	@GetMapping("/inventorys")
	public List<Inventory> getAllInventrory(Model m) {
		 return is.getAllInventory();
	}
	@PostMapping("/inventory/{id}")
	public List<Inventory> searchInventory(@PathVariable("id") int id) {
		return is.searchInventory(id);
	}
	@PutMapping("/inventory/{id}")
	public Inventory updateInventory(@RequestBody Inventory inventory,@PathVariable("id")int id) {
		return is.editInventory(inventory,id);
	}
	@RequestMapping("/inventory/{id}")
	public void deleteInventory(@PathVariable("id") int id,Model m) {
		is.deleteInventory(id);
	}
}
