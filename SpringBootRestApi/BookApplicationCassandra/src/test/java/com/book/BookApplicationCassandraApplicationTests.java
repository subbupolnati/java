package com.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.model.Book;
import com.book.service.BookService;

@SpringBootTest
class BookApplicationCassandraApplicationTests {

	Book book;
	BookService bs=Mockito.mock(BookService.class);
	List<Book> al=new ArrayList<Book>();
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init() {
		book=new Book();
		book.setBookId(10);
		book.setBookName("Core Java");
		book.setPrice(250);
		Book a1=new Book(1,"SpringBoot",500);
		Book a2=new Book(2,"Java",500);
		al.add(a1);al.add(a2);
	}
	@Test
	void test1() {
		Book a1=book;
		assertSame(a1,book);
	}
	@Test
	void test2() {
		assertEquals(book.getBookName(),"Core Java");
	}
	@Test
	void test3() {
		assertNotNull(book.getBookId());
	}
	@Test
	void test4() {
	assertEquals(book,book);
	}
	@Test
	void test5() {
		when(bs.insertNewBook(book)).thenReturn(book);
	}
	@Test
	void test6() {
		doThrow(new NullPointerException()).when(bs).deleteBook(0);
	}
	@Test
	void test7() {
		doThrow(new NullPointerException()).when(bs).getBookById(0);
	}
	@Test
	void test8() {
		when(bs.getBookById(10)).thenReturn(book);
	}
	@Test
	void test9() {
		bs.getAllBooks();
		verify(bs,times(1)).getAllBooks();
	}
	@Test
	void test10() {
	doReturn(al).when(bs).getAllBooks();
	
	}

}
