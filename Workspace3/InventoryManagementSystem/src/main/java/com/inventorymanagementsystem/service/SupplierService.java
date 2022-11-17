package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.SupplierNotFoundException;
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
		try{
			return sr.findAll();
		}catch(SupplierNotFoundException s) {
			throw new SupplierNotFoundException("supplier not found");
		}
	}
	public Supplier editSupplier(Supplier supplier,int supplierid) {
		Optional<Supplier> optional=sr.findById(supplierid);
		if(optional.isPresent()) {
			supplier=optional.get();
			return sr.save(supplier);
		}
		else
			throw new SupplierNotFoundException("supplier not found"+supplierid);
	}
	public void deleteSupplier(int supplierid) {
		try {
			sr.deleteById(supplierid);
		}
		catch(SupplierNotFoundException s) {
			throw new SupplierNotFoundException("supplier not found"+supplierid);
		}
	}
	public List<Supplier> searchSupplier(int supplierid){
		try {
		return sr.findBySupplierid(supplierid);
		}
		catch(SupplierNotFoundException s) {
			throw new SupplierNotFoundException("supplier not found"+supplierid);
		}
	}
	public Supplier validate(String username,String password) {
		return sr.findBySupplierusernameAndSupplierpassword(username, password);
	}
	public Supplier validateUser(String username) {
		return sr.findBySupplierusername(username);
	}
}
