package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.InventoryNotFoundException;
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
		try {
		return inventoryRepo.findAll();
		}
		catch(InventoryNotFoundException e){
			throw new InventoryNotFoundException("inventory not found ");
		}
	}
	public Inventory editInventory(Inventory inventory, int inventoryid) {
		Optional<Inventory> optional= inventoryRepo.findById(inventoryid);
		if(optional.isPresent()) {
			inventory=optional.get();
			return inventoryRepo.save(inventory);
		}
		else
	         throw new InventoryNotFoundException("inventory not found for id : " +inventoryid);
	}
	public void deleteInventory(int inventoryid) {
		try{
			inventoryRepo.deleteById(inventoryid);
		}
		catch(InventoryNotFoundException e){
			throw new InventoryNotFoundException("inventory not found for id : " +inventoryid);
		}
	}
	public List<Inventory> searchInventory(int inventoryid){
		try{
			return inventoryRepo.findByInventoryid(inventoryid);
		}catch(InventoryNotFoundException e){
			throw new InventoryNotFoundException("inventory not found for id : " +inventoryid);
		}
	}
}
