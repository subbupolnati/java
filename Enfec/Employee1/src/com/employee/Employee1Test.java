package com.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.employee.manager.Marketing_Executive;
import com.employee.marketing.Manager;

class Employee1Test {
	@Mock
	Employee1 e;
	Employee1 e1;
	Marketing_Executive me;
	Manager m;
	@BeforeEach
	void setup() throws Exception{
	e=new Marketing_Executive(100,"subbu",10000);
	e1=new Manager(101,"su",12000);
	}
	@Test
	void test() {
		assertTrue(e.bsal>=10000);
		System.out.println("Test case 0 is passed");
	}
	@Test
	void test1() {
		assertFalse(e.gross>=10900);
		System.out.println("Test case 1 is passed");
	}
	@Test
	void test2() {
		assertNotSame(e,e1);
		System.out.println("Test case 2 is passed");
	}
	@Test
	void test3() {
		assertNotSame(e,e1);
		System.out.println("Test case 3 is passed");
	}
	@Test
	void test4() {
		assertEquals(e1.calculateSalary(),13200);
		System.out.println("Test case 4 is passed");
	}
	@Test
	void test5() {
		assertEquals(e.calculateSalary(),10900);
		System.out.println("Test case 5 is passed");
	}
	@Test
	void test6() {
		assertTrue(e1.eid>=101);
		System.out.println("Test case 6 is passed");
	}
	@Test
	void test7() {
		assertTrue(e1.ename=="su");
		System.out.println("Test case 7 is passed");
	}
	@Test
	void test8() {
		assertTrue(e.ename=="subbu");
		System.out.println("Test case 8 is passed");
	}
	@Test
	void test9() {
		assertNotNull(e.bsal);
		System.out.println("Test case 9 is passed");
	}
	/*@Test
	void test10() {
		when(e.calculateSalary()).thenReturn(10900);
		assertEquals(10900,e.calculateSalary());
		verify(e,times(1)).calculateSalary();
		System.out.println("Test case 10 is passed");
	}
	@Test
	void test11() {
		when(me.calcTa1(10000)).thenReturn(500);
		assertEquals(500,me.calcTa1(10000));
		System.out.println("Test case 11 is passed");
	}
	@Test
	void test12() {
		when(me.calcSalary1(10000,500,200,200)).thenReturn(10900);
		assertEquals(10900,me.calcSalary1(10000,500,200,200));
		System.out.println("Test case 12 is passed");
	}
	
	@Test
	void test13() {
		when(m.calculateSalary()).thenReturn(13200);
		assertEquals(13200,m.calculateSalary());
		System.out.println("Test case 13 is passed");
	}
	@Test
	void test14() {
		when(me.calcSalary()).thenReturn(10900);
		verify(me,times(1)).calcSalary();
		System.out.println("Test case 14 is passed");
	}*/
}
