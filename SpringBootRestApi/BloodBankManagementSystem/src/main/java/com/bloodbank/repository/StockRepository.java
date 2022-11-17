package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	public List<Stock> findByStockblood(String bloodgroup);
}
