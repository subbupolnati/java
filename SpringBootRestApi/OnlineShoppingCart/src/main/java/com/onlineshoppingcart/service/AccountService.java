package com.onlineshoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.Account;
import com.onlineshoppingcart.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	public Account insertAccount(Account account) {
		return accountRepo.save(account);
	}
	
	public Account getAccount(int accountid) {
		return accountRepo.findById(accountid).get();
	}
}
