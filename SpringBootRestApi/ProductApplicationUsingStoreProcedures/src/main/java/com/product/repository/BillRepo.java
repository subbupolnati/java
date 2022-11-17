package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.product.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill,Integer> {

	@Procedure(procedureName = "insert_bill")
	void saveBill(int bill_no,int amount,int selected_quantity,int product_id,String userid);;
	@Procedure(procedureName = "update_amount",outputParameterName="amt")
	int updateBill(int sq,int pid,int bno,String uid);
}
