package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Stock;
import com.bloodbank.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;
	
	
	public Stock addStock(Stock stock) {
		return stockRepo.save(stock);
	}
	public List<Stock> getAllStocks(){
		return stockRepo.findAll();
	}
	public List<Stock> searchStocks(String bloodgroup) {
		return stockRepo.findByStockblood(bloodgroup);
	}
	public Stock updateStock(int stockid) {
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
	
}
