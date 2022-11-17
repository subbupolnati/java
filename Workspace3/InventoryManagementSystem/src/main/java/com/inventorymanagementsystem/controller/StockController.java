package com.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagementsystem.model.Stock;
import com.inventorymanagementsystem.service.StockService;

@RestController
public class StockController {
	@Autowired
	StockService ss;
	
	@PostMapping("/stock")
	public Stock saveStock(@RequestBody Stock stock){
		return ss.addStock(stock);
	}
	@GetMapping("/stocks")
	public List<Stock> getAllStock(Model m) {
		 return ss.getAllStock();
	}
	@PostMapping("/stock/{id}")
	public List<Stock> searchStock(@PathVariable("id") int id,Model m) {
		return ss.searchStock(id);
	}
	@PutMapping("/stock/{id}")
	public  Stock updateStock(@RequestBody Stock stock, @PathVariable("id")int id) {
		return ss.editStock(stock, id);
	}
	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable("id") int id,Model m) {
		ss.deleteStock(id);
	}
}
