package com.book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class TestBookApplicationTest {
	@Mock
	Book1 book;
	Author auth;
	Librarein l=Mockito.mock(Librarein.class);
	@BeforeEach
	void setUp() throws Exception {
		auth=new Author(101,"james");
		book=new Book1(10, "java",500,auth);
	}
	@Test
	void test1() {
		assertNotNull(book.getBook_name(),"java");
		System.out.println("testcase1");
	}
	@Test
	void test2() {
		assertTrue(book.getBook_name()=="java");
		System.out.println("testcase2");
	}
	@Test
	void test3() {
		assertTrue(book.book_id==10);
		System.out.println("testcase3");
	}
	@Test
	void test4() {
		assertNotSame(book,auth);
		System.out.println("testcase4");
	}
	@Test
	void test5() {
		ArrayList<Book1> a=Mockito.spy(ArrayList.class);
		a.add(new Book1(11,"python",25,auth));
		assertEquals(1,a.size());
		System.out.println("testcase5");
	}
	@Test
	void test6() {
		when(l.add(book)).thenReturn(true);
		assertEquals(true,l.add(book));
		System.out.println("testcase6");
	}
	@Test
	void test7() {
		when(l.add(book)).thenReturn(true);
		assertEquals(true,l.add(book));
		verify(l,times(1)).add(book);
		System.out.println("testcase7");
	}
	@Test
	void test8() {
		when(l.add(book)).thenReturn(true);
		assertEquals(true,l.add(book));
		verify(l,atMost(1)).add(book);
		System.out.println("testcase8");
	}
	@Test
	void test9() {
		assertTrue(book.getBook_name()=="java");
		
	}
}
