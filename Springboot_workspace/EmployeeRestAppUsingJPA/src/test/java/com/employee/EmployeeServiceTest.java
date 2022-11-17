package com.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;
import com.employee.service.EmployeeService;

class EmployeeServiceTest {

	@Mock
	EmployeeRepository er;
	
	@Autowired
	EmployeeService es;
	List<Employee> al;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	es=new EmployeeService(this.er);
	Department d=new Department();
	d.setDid(10);
	d.setDname("It");
	al=new ArrayList<Employee>();
	al.add(new Employee(101,"subbu",10000,d));
	al.add(new Employee(102,"ram",12000,d));
	}

	@Test
	void testVerifyFindAllEmployee() {
		es.getAllEmployees();
		verify(this.er).findAll();
	}
	@Test
	void testEmployeeId() {
		Employee e=new Employee(100,"harshi",10000);
		when(er.save(e)).thenReturn(e);
		assertNotNull(e);
	}
	@Test
	void testEmployeeId2() {
		Employee e=new Employee(100,"harshi",10000);
		when(es.insertEmployee(e)).thenReturn(e);
		assertNotNull(e);
	}
	@Test
	void testVerifyFindAllEmployee3() {
		es.getAllEmployees();
		assertEquals(2,al.size());
	}
	@Test
	void testGetEmployee() {
		when(er.getById(100)).thenReturn(new Employee(100,"harshi",10000));
		Employee e=er.getById(100);
		assertEquals(100,e.getEmpid());	
	}
	@Test
	void testGetEmployee1() {
		when(er.getById(100)).thenReturn(new Employee(100,"harshi",10000));
		Employee e=er.getById(100);
		assertEquals("harshi",e.getEname());
	}
	@Test 
	void testDelete() {
		er.deleteById(100);
		assertTrue(true);
	}
	@Test 
	void testExist() {
		Employee e=new Employee(101,"sssss",10000);
		boolean b=er.existsById(e.getEmpid());
		assertThat(b).isFalse();
	}
	@Test
	void testUpdate() {
		Employee e1=new Employee(100,"subbu",10000);
		e1.setEname("subb");
		when(es.update(e1,101)).thenReturn(e1);
		assertEquals("subb",e1.getEname());
	}
	@Test
	void testUpdate2() {
		Employee e1=new Employee(100,"subbu",10000);
		e1.setSalary(150000);;
		when(es.update(e1,101)).thenReturn(e1);
		assertEquals(150000,e1.getSalary());
	}
}
