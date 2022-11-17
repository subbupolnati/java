package com.product.service;


import java.util.List;
import java.util.Optional;

import javax.imageio.spi.RegisterableService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Bill;
import com.product.repository.BillRepo;

@Service
public class BillService {

	@Autowired
	BillRepo billRepo;
	
	@PersistenceContext
	private EntityManager entityManager;
	int amount;
	public int saveBill(Bill bill) {
		billRepo.saveBill(bill.getBill_no(),bill.getAmount(),bill.getSelected_quantity(),bill.getProduct().getProduct_id(),bill.getUser().getUserid());
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("update_amount")
					.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN)
					.registerStoredProcedureParameter(2,Integer.class,ParameterMode.IN)
					.registerStoredProcedureParameter(3, Integer.class,ParameterMode.IN)
					.registerStoredProcedureParameter(4,String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(5, Integer.class,ParameterMode.OUT)
					.setParameter(1,bill.getSelected_quantity())
					.setParameter(2, bill.getProduct().getProduct_id())
					.setParameter(3, bill.getBill_no())
					.setParameter(4, bill.getUser().getUserid());
					query.execute();
					int amount=(int) query.getOutputParameterValue(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
		//return billRepo.updateBill(bill.getSelected_quantity(),bill.getProduct().getProduct_id(),bill.getBill_no(),bill.getUser().getUserid());
		}
	public List<Bill> getAllBills(){
		return billRepo.findAll();
	}
}
