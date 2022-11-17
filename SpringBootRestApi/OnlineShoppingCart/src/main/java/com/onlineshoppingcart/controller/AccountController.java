package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onlineshoppingcart.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
}
