package com.airlinesproducer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airlinesproducer.model.Airlines;
import com.airlinesproducer.model.Passenger;
import com.airlinesproducer.service.AirlinesService;
import com.airlinesproducer.service.PassengerService;

@SpringBootTest
class AirlinesProducerApplicationTests {

	Airlines airline;
	Passenger passenger;
	PassengerService passengerService =Mockito.mock(PassengerService.class);
	AirlinesService airlineService =Mockito.mock(AirlinesService.class);
	List<Airlines> al=new ArrayList<Airlines>();
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init() {
		airline=new Airlines();
		passenger=new Passenger(passengerService);
		airline.setName("kuwait");
		airline.setSlogan("high to fly");
		Airlines a1=new Airlines(1,"Dubai Airlines","Dubai","logo.png","happy flying","Dubai","www.dubaiairlines.com","1980");
		Airlines a2=new Airlines(2,"Indian Airlines","India","logo.png","happy flying","India","www.indianairlines.com","1950");
		al.add(a1);al.add(a2);
		Passenger p=new Passenger(10,"subbu","250",airline);
	}
	@Test
	void test1() {
		Airlines a1=airline;
		assertSame(airline, a1);
	}
	@Test
	void test2() {
	assertEquals(airline, airline);
	}
	@Test
	void test3() {
	assertEquals("kuwait","kuwait");
	}
	@Test
	void test4() {
	assertNotEquals("dubai","kuwait");
	}
	@Test
	void test5() {
		assertEquals(airline.getName(),"kuwait");
	}
	@Test
	void test6() {
		assertThrows(NullPointerException.class,()->airline.getCountry().length());
	}
	@Test
	void test7() {
		assertSame("high to fly",airline.getSlogan());
	}
	@Test
	void test8() {
		assertNull(airline.getCountry());
	}
	@Test
	void test9() {
		assertNotNull(airline.getSlogan());
	}
	@Test
	void test10() {
		when(passengerService.insertNewPassenger(passenger)).thenReturn(passenger);
	}
	@Test
	void test11() {
		doThrow(new NullPointerException()).when(passengerService).deletePassengerById(0);;
	}
	@Test
	void test12() {
		doThrow(new NullPointerException()).when(passengerService).getPassengerById(0);
	}
	@Test
	void test13() {
		when(passengerService.getPassengerById(10)).thenReturn(passenger);
	}
	@Test
	void test14() {
		airlineService.getAllAirlines();
		verify(airlineService,times(1)).getAllAirlines();
	}
	@Test
	void test15() {
	doReturn(al).when(airlineService).getAllAirlines();
	
	}
	@Test
	void test16() {
	verify(passengerService,never()).getAllPassenger();
	}
	@Test
	void test17() {
		when(airlineService.getAllAirlines()).thenReturn(al);
		assertEquals(al,airlineService.getAllAirlines());
		verify(airlineService,atLeast(1)).getAllAirlines();
	}
	@Test
	void test18() {
		when(airlineService.getAllAirlines()).thenReturn(al);
		assertEquals(al,airlineService.getAllAirlines());
		assertEquals(al,airlineService.getAllAirlines());
		assertEquals(al,airlineService.getAllAirlines());
		verify(airlineService,atMost(3)).getAllAirlines();
	}
	@Test
	void test19() {
		when(airlineService.getAllAirlines()).thenReturn(al);
		assertEquals(2,al.size());
	}
}
