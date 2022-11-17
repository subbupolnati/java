package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Invoice;
import com.employee_timesheet.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//This method save Invoices in database using predefined save method  
	public Invoice insertInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	//this method getting all Invoices in invoice table
	public List<Invoice> getAllInvoices(){
		return invoiceRepository.findAll();
	}
	//this method getting Invoice details based on Invoice id
	public Invoice getInvoiceById(int InvoiceId) {
		//this statement get Invoice based on id if Invoice is not available optional is null
		Invoice invoice=invoiceRepository.findById(InvoiceId).get();
		//if Invoice instance not null execute if block other wise it returns Holiday null;
		if(invoice!=null)
			return invoice;
		else
			throw new NotFoundException("Invoice not found for id : " +InvoiceId);
	}
	//this method update Invoice based on holidaytId
	public Invoice updateInvoice(Invoice invoice,int invoiceId) {
		//this statement get Invoice based on id if Invoice is not available optional is null
		Optional<Invoice> optional=invoiceRepository.findById(invoiceId);
		//if optional instance not null execute if block other wise it returns Holiday null;
		if (optional.isPresent()) {
		    invoice.setInvoiceId(invoiceId);
		    return invoiceRepository.save(invoice);
		}else
		   throw new NotFoundException("Invoice not found for id : " +invoiceId);
	}
	//In this method delete Invoice based on id
	public void deleteInvoice(int invoiceId) {
			invoiceRepository.deleteById(invoiceId);
	}
}
