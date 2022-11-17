package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Stock;
import com.inventorymanagementsystem.repository.StockRepo;

@Service
public class StockService {
	@Autowired
	private StockRepo stockRepo;
	
	public Stock addStock(Stock stock) {
		return stockRepo.save(stock);
	}
	public List<Stock> getAllStock(){
		return stockRepo.findAll();
	}
	public Stock editStock(int stockid) {
		Optional<Stock> optional=stockRepo.findById(stockid);
		Stock stock=null;
		if(optional.isPresent()) {
			stock=optional.get();
			return stock;
		}
		return stock;
	}
	public void deleteStock(int stockid) {
		stockRepo.deleteById(stockid);
	}
	public List<Stock> searchStock(int stockid){
		return stockRepo.findByStockid(stockid);
	}
}
