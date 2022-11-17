package com.book.controller;

import java.net.URI;
import java.util.List;
import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.model.Book;
import com.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	Logger logger=LoggerFactory.getLogger("BookController.class");
	@PostMapping("/book")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
		logger.info("book details adding");
		Book b= bookService.insertNewBook(book);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{bookId}").buildAndExpand(b.getBookId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		logger.info("All book details");
		return bookService.getAllBooks();
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId) {
		logger.info("book details getting by id");
		return bookService.getBookById(bookId);
	}
	@PutMapping("/book/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
		logger.info("book details updating");
		return bookService.updateBook(book, bookId);
	}
	@DeleteMapping("/book/{bookId}")
	public void deleteBook(@PathVariable("bookId")int bookId) {
		logger.info("book delete by id");
		bookService.deleteBook(bookId);
	}
}
