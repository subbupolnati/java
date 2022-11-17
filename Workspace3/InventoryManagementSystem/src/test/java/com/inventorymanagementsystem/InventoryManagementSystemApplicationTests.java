package com.inventorymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

	
	Inventory inventory;
	Payment payment;
	Permission permission=new Permission(1,"admin","admin","admin");
	Permission permission1=new Permission(2,"supplier","supplier","supplier");
	Permission permission2=new Permission(3,"customer","customer","customer");
	Role role=new Role(1,"admin","admin",permission);;
	Stock stock;
	Supplier supplier=new Supplier(1,"subbu","9951933459","subbu@gmail.com","subbu","subbu","hyd",permission1);
	User user;
	Customer customer=new Customer(1,"veera","9951933459","veera@gmail.com","veera","veera","hyd",permission2);
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
	
	Role role1=new Role(2,"supplier","supplier",permission1);
	Role role2=new Role(3,"customer","customer",permission2);
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init() {
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
	@Test
	void test3() {
	assertEquals("admin","admin");
	}
	@Test
	void test4() {
	assertNotEquals("supplier","customer");
	}
	@Test
	void test5() {
		assertEquals(customer.getCustomername(),"veera");
	}
	@Test
	void test6() {
		assertThrows(NullPointerException.class,()->user.getUsername());
	}
	@Test
	void test7() {
		assertSame("admin",permission.getPermissiontitle());
	}
	@Test
	void test8() {
		Role r=role;
		assertEquals(role,r);
	}
	@Test
	void test9() {
		assertNotNull(customer.getCustomeremail());
	}
	@Test
	void test10() {
		assertEquals(permission.getPermissionmodule(),"admin");
	}
	@Test
	void test11() {
		assertNotEquals(permission.getPermissiontitle(),"ADMIN");
	}
	@Test
	void test12() {
		assertTrue(customer.getCustomerid()==1);
	}
	@Test
	void test13() {
		assertFalse(customer.getCustomername()=="Veera");
	}
	@Test
	void test14() {
		assertEquals(supplier.getSupplieremail(),"subbu@gmail.com");
	}
	@Test
	void test15() {
		assertFalse(permission2.equals(permission));
	}
	@Test
	void test16() {
		assertEquals(permission1,supplier.getPermission());
	}
	@Test
	void test17() {
		assertTrue(supplier.getSuppliername().equalsIgnoreCase("subbu"));
	}
	@Test
	void test18() {
		assertTrue(customer.getCustomeraddress().equalsIgnoreCase("hyd"));
	}
	@Test
	void test19() {
		assertTrue(permissionList.size()==3);
	}
	//Mockito TestCasess
	
	@Test
	void test20() {
		when(cs.addCustomer(customer)).thenReturn(customer);
	}
	@Test
	void test21() {
		doThrow(new NullPointerException()).when(ps).editPermission(permission, 0);
	}
	@Test
	void test22() {
		doThrow(new NullPointerException()).when(stockService).searchStock(5);
	}
	@Test
	void test23() {
		when(ss.addSupplier(supplier)).thenReturn(supplier);
	}
	@Test
	void test24() {
		is.getAllInventory();
		verify(is,times(1)).getAllInventory();
	}
	@Test
	void test25() {
	doReturn(stockList).when(stockService).getAllStock();
	
	}
	@Test
	void test26() {
	verify(ss,never()).addSupplier(supplier);
	}
	@Test
	void test27() {
		when(ps.getPermissions()).thenReturn(permissionList);
		assertEquals(permissionList,ps.getPermissions());
		verify(ps,atLeast(1)).getPermissions();
	}
	@Test
	void test28() {
		when(is.getAllInventory()).thenReturn(inventoryList);
		assertEquals(inventoryList,is.getAllInventory());
		assertEquals(inventoryList,is.getAllInventory());
		assertEquals(inventoryList,is.getAllInventory());
		verify(ps,atMost(3)).getPermissions();
	}
	@Test
	void test29() {
		when(rs.getAllRole()).thenReturn(roleList);
		assertEquals(3,roleList.size());
	}
	@Test 
	void test30() {
		when(ps.addPermission(permission)).thenReturn(permission);
	}
	@Test
	void test31() {
		doReturn(inventory).when(is).addInventory(inventory);
	}
	@Test
	void test32() {
		doReturn(stock).when(stockService).editStock(stock, 1);
	}
	@Test
	void test33() {
		when(cs.addCustomer(customer)).thenReturn(customer);
	}
	@Test
	void test34() {
		doReturn(permissionList).when(ps).searchPermission(4);
	}
	@Test
	void test35() {
		doReturn(roleList).when(rs).searchRole(2);
	}
	@Test
	void test36() {
		doReturn(roleList).when(rs).searchRole(2);
	}
	@Test
	void test37() {
		doReturn(inventoryList).when(is).searchInventory(1);
	}
	@Test
	void test38() {
		doReturn(supplierList).when(ss).searchSupplier(2);
	}
	@Test
	void test39() {
		doReturn(supplier).when(ss).addSupplier(supplier);
	}
}
