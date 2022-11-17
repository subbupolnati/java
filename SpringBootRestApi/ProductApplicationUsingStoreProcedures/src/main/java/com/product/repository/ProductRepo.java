package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Category;
import com.product.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Procedure(procedureName = "insert_product")
	void saveProduct(int product_id, int availabel_quntity, String name, int price, int category_id);

	

}
