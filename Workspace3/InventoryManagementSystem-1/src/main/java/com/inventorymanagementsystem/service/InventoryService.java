package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Inventory;
import com.inventorymanagementsystem.repository.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	
	public List<Inventory> getAllInventory(){
		return inventoryRepo.findAll();
	}
	public Inventory editInventory(int inventoryid) {
		Optional<Inventory> optional= inventoryRepo.findById(inventoryid);
		Inventory inventory=null;
		if(optional.isPresent()) {
			inventory=optional.get();
			return inventory;
		}
		return inventory;
	}
	public void deleteInventory(int inventoryid) {
		inventoryRepo.deleteById(inventoryid);
	}
	public List<Inventory> searchInventory(int inventoryid){
		return inventoryRepo.findByInventoryid(inventoryid);
	}
}
