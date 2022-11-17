package com.inventorymanagementsystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventorymanagementsystem.model.Supplier;
import com.inventorymanagementsystem.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	private SupplierService ss;
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	@PostMapping("/supplier")
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
		supplier.setSupplierpassword(this.passwordencoder.encode(supplier.getSupplierpassword()));
		Supplier s=ss.addSupplier(supplier);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(s.getSupplierpassword()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/suppliers")
	public List<Supplier> getAllSupplier(Model m) {
		return ss.getAllSupplier();
	}
	@PostMapping("/supplier/{id}")
	public List<Supplier>  searchSupplier(@PathVariable("id") int id) {
		return ss.getAllSupplier();
	}
	@PutMapping("/supplier/{id}")
	public Supplier updateSupplier(@RequestBody Supplier supplier,@PathVariable("id")int id,Model m) {
		return ss.editSupplier(supplier,id);
	}
	@DeleteMapping("/supplier/{id}")
	public void deleteSupplier(@PathVariable("id") int id,Model m) {
		ss.getAllSupplier();
	}
	@GetMapping("/supplier/{username}")
	public Supplier validateUser(@PathVariable("username")String username){
		return ss.validateUser(username);
	}
}
