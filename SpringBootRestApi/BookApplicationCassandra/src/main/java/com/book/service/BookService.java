package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exceptions.BookNotFoundException;
import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	public Book insertNewBook(Book book) {
		return bookRepo.save(book);
	}
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book getBookById(int bookId) {
		Optional<Book> optional=bookRepo.findById(bookId);
		Book book=null;
		if(optional.isPresent()) {
			book=optional.get();
			return book;
		}else
			throw new BookNotFoundException("Book not found Id "+bookId);
	}
	public Book updateBook(Book book,int bookId) {
		Optional<Book> optional=bookRepo.findById(bookId);
		if(optional.isPresent()) {
			book.setBookId(bookId);
			return bookRepo.save(book);
		}
		else
			throw new BookNotFoundException("Book not found Id "+bookId);
		
	}
	public void deleteBook(int bookId) {
		try{
			bookRepo.deleteById(bookId);
		}catch(Exception e) {
			throw new BookNotFoundException("Book not found Id "+bookId);
		}
	}
}
