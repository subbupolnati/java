package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.model.Bill;
import com.product.model.Product;
import com.product.repository.BillRepo;
import com.product.service.BillService;
import com.product.service.ProductService;

@Controller
public class BillController {

	@Autowired
	BillService billService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/billgenerate/{pid}")
	public String billGenerate(@PathVariable("pid") int pid,Model m) {
		Product p=productService.update(pid);
		Bill bill=new Bill();
		bill.setAmount(p.getPrice());
		bill.setProduct(p);
		m.addAttribute("bill", bill);
		return "billgenerate";
	}
	@RequestMapping("/billsave")
	public String billSave(@ModelAttribute("bill") Bill bill,Model m) {
		int amount=billService.saveBill(bill);
		m.addAttribute("amount",amount);
		System.out.println(amount);
		return"success";
	}
	@RequestMapping("/allbills")
	public String getAllbills(Model m) {
		List<Bill> billList=billService.getAllBills();
		m.addAttribute("blist", billList);
		return "viewBills";
		
	}
}
