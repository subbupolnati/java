package com.inventorymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventorymanagementsystem.model.Customer;
import com.inventorymanagementsystem.model.Inventory;
import com.inventorymanagementsystem.model.Payment;
import com.inventorymanagementsystem.model.Permission;
import com.inventorymanagementsystem.model.Role;
import com.inventorymanagementsystem.model.Stock;
import com.inventorymanagementsystem.model.Supplier;
import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.service.CustomerService;
import com.inventorymanagementsystem.service.InventoryService;
import com.inventorymanagementsystem.service.PaymentService;
import com.inventorymanagementsystem.service.PermissionService;
import com.inventorymanagementsystem.service.RoleService;
import com.inventorymanagementsystem.service.StockService;
import com.inventorymanagementsystem.service.SupplierService;
import com.inventorymanagementsystem.service.UserService;

@SpringBootTest
class InventoryManagementSystemApplicationTests {

	Customer customer;
	Inventory inventory;
	Payment payment;
	Permission permission;
	Role role;
	Stock stock;
	Supplier supplier;
	User user;
	CustomerService cs=Mockito.mock(CustomerService.class);
	InventoryService is=Mockito.mock(InventoryService.class);
	SupplierService ss=Mockito.mock(SupplierService.class);
	PermissionService ps=Mockito.mock(PermissionService.class);
	StockService stockService=Mockito.mock(StockService.class);
	RoleService rs=Mockito.mock(RoleService.class);
	PaymentService paymentS=Mockito.mock(PaymentService.class);
	UserService us=Mockito.mock(UserService.class);
	ArrayList<Customer> custList=new ArrayList<Customer>();
	ArrayList<Stock> stockList=new ArrayList<Stock>();
	ArrayList<Inventory> inventoryList=new ArrayList<Inventory>();
	ArrayList<Permission> permissionList=new ArrayList<Permission>();
	ArrayList<Supplier> supplierList=new ArrayList<Supplier>();
	ArrayList<Role> roleList=new ArrayList<Role>();
	
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init() {
		 permission=new Permission(1,"admin","admin","admin");
		Permission permission1=new Permission(2,"supplier","supplier","supplier");
		Permission permission2=new Permission(3,"customer","customer","customer");
		role=new Role(1,"admin","admin",permission);
		Role role1=new Role(2,"supplier","supplier",permission1);
		Role role2=new Role(3,"customer","customer",permission2);
		customer=new Customer(1,"veera","9951933459","veera@gmail.com","veera","veera","hyd",permission2);
		supplier=new Supplier(1,"subbu","9951933459","subbu@gmail.com","subbu","subbu","hyd",permission1);
		inventory=new Inventory(1,"mobile","2", "grocery","5", permission2);
		Inventory inventory1=new Inventory(2,"laptop","1", "electronics","5", permission2);
		Inventory inventory2=new Inventory(3,"Shirt","3", "cloths","5", permission2);
		stock=new Stock(1,"mobile","2", "grocery","5", permission2);
		Stock stock1=new Stock(2,"laptop","1", "electronics","5", permission2);
		Stock stock2=new Stock(3,"Shirt","3", "cloths","5", permission2);
		custList.add(customer);
		permissionList.add(permission1);permissionList.add(permission2);permissionList.add(permission);
		supplierList.add(supplier);
		roleList.add(role);roleList.add(role1);roleList.add(role2);
		inventoryList.add(inventory);inventoryList.add(inventory1);inventoryList.add(inventory2);
		stockList.add(stock);stockList.add(stock1);stockList.add(stock2);	
	}
	@Test
	void test1() {
		Customer c=customer;
		assertSame(customer,c);
	}
	@Test
	void test2() {
	assertEquals(customer, customer);
	}
	/*@Test
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
	}*/
}
