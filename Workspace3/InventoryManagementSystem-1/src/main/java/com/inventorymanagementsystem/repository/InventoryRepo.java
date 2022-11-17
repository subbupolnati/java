package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer>{
	public List<Inventory> findByInventoryid(int inventoryid);
}
