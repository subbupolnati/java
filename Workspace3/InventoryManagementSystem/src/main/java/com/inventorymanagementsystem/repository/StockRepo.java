package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer>{
	public List<Stock> findByStockid(int stockid);
}
