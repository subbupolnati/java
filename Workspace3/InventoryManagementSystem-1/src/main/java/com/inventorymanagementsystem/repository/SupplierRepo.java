package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer>{

	public List<Supplier> findBySupplierid(int supplierid);

	public Supplier findBySupplierusernameAndSupplierpassword(String username, String password);
}
