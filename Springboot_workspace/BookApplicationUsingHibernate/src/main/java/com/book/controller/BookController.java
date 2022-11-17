package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.dao.BookDAO;
import com.book.model.Book;

@Controller
public class BookController {
	@Autowired
	BookDAO bdao;
	@RequestMapping("/add")
	public String addBook(@ModelAttribute("book") Book book) {
		bdao.insertBook(book);
		return "index.jsp";	
	}

}
