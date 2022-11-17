package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.StockNotFoundException;
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
		try{
			return stockRepo.findAll();
		}catch(StockNotFoundException e) {
			throw new StockNotFoundException("stock not found");
		}
	}
	public Stock editStock(Stock stock,int stockid) {
		Optional<Stock> optional=stockRepo.findById(stockid);
		if(optional.isPresent()) {
			stock=optional.get();
			return stockRepo.save(stock);
		}
		else
			throw new StockNotFoundException("stock not found"+stockid);
	}
	public void deleteStock(int stockid) {
		try{
			stockRepo.deleteById(stockid);
		}catch(StockNotFoundException e) {
			throw new StockNotFoundException("stock not found"+stockid);
		}
	}
	public List<Stock> searchStock(int stockid){
		try{
			return stockRepo.findByStockid(stockid);
		}catch(StockNotFoundException e) {
			throw new StockNotFoundException("stock not found"+stockid);
		}
	}
}
