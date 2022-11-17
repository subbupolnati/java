package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Supplier;
import com.inventorymanagementsystem.repository.SupplierRepo;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepo sr;

	public Supplier addSupplier(Supplier supplier) {
		return sr.save(supplier);
	}
	public List<Supplier> getAllSupplier(){
		return sr.findAll();
	}
	public Supplier editSupplier(int supplierid) {
		Optional<Supplier> optional=sr.findById(supplierid);
		Supplier supplier=null;
		if(optional.isPresent()) {
			supplier=optional.get();
			return supplier;
		}
		return supplier;
	}
	public void deleteSupplier(int supplierid) {
		sr.deleteById(supplierid);
	}
	public List<Supplier> searchSupplier(int supplierid){
		return sr.findBySupplierid(supplierid);
	}
	public Supplier validate(String username,String password) {
		return sr.findBySupplierusernameAndSupplierpassword(username, password);
	}

}
