package com.calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatorTest {
	Calculator c;
	CalculatorService service=Mockito.mock(CalculatorService.class);
	@BeforeEach
	void setUp() throws Exception {
		c=new Calculator(service);
	}

	@Test
	void testAdd() {
		when(service.add(5, 10)).thenReturn(15);
		assertEquals(15,service.add(5, 10));
		System.out.println("Adding Test case is passed");
	}
	@Test
	void testSub() {
		when(service.sub(15, 10)).thenReturn(5);
		assertEquals(5,service.sub(15, 10));
		System.out.println("Subtraction Test case is passed");
	}
	@Test
	void testMul() {
		when(service.mul(5, 10)).thenReturn(50);
		assertEquals(50,service.mul(5, 10));
		System.out.println("Multification Test case is passed");
	}

	@Test
	void testDiv() {
		when(service.div(15, 5)).thenReturn(3.0);
		assertEquals(3.0,service.div(15, 5));
		System.out.println("Division Test case is passed");
	}

}
