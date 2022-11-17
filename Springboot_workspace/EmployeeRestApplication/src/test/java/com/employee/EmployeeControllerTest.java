package com.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.employee.controller.EmployeeController;
import com.employee.employeeexception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	EmployeeRepository er;
	@Autowired
	EmployeeController ec;
	@Autowired
	MockMvc mvc;
	@MockBean
	EmployeeService es;
	
	@Test
	void testEmployeeSearchById() throws Exception {
		Employee e=new Employee();
		e.setEmpid(100);
		e.setEname("subbu");
		e.setSalary(10000);
		es.insertEmployee(e);
		System.out.println(e);
		when(es.getEmployee(100)).thenReturn(e);
		mvc.perform(MockMvcRequestBuilders.get("/employee/100"))
		.andExpect(jsonPath("$.empid").value(100))
		.andExpect(MockMvcResultMatchers.jsonPath("$.ename").value("subbu"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(10000))
		.andExpect(status().isOk())
		.andDo(print());
		System.out.println("Id is Exist");
	}
	@Test
	void testAddnewEmployee() throws Exception {

		Employee e=new Employee();
		e.setEmpid(101);
		e.setEname("subbu");
		e.setSalary(10000);
		es.insertEmployee(e);
		when(es.insertEmployee(e)).thenReturn(e);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/employee")
	            .contentType("Application/json;charset=UTF-8")
	            .accept("Application/json")
	            .content(new ObjectMapper().writeValueAsString(e));
		mvc.perform(mockRequest)
		//.andExpect(MockMvcResultMatchers.jsonPath("$.empid",notNullValue()))
				/*
				 * .andExpect(jsonPath("$.empid").value(101))
				 * .andExpect(MockMvcResultMatchers.jsonPath("$.ename").value("subbu"))
				 * .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(10000))
				 */
		.andDo(print());
	}
	@Test
	void testAllEmployees() throws Exception {
		ArrayList<Employee> al=new ArrayList<Employee>();
		al.add(new Employee(100,"subbu",10000));
		al.add(new Employee(101,"ssss",15000));
		when(es.getAllEmployees()).thenReturn(al);
		MvcResult result=mvc.perform(get("/employee"))
				.andExpect(status().isOk()).andReturn();
		String actualResponce=result.getResponse().getContentAsString();
		System.out.println("actualResponse is"+actualResponce);
		String expectedResult=new ObjectMapper().writeValueAsString(al);
		System.out.println("Expected Result is"+expectedResult);
		assertThat(actualResponce).isEqualTo(expectedResult);
	}
	@Test
	void testDeleteEmployee() throws Exception {
		Employee e=new Employee();
		e.setEmpid(101);
		e.setEname("subbu");
		e.setSalary(10000);
		Mockito.doNothing().when(es).deleteEmployee(101);
		mvc.perform(delete("/employee/101"))
		.andExpect(status().isOk());
		Mockito.verify(es,times(1)).deleteEmployee(101);
	}
	@Test
	void testNoEmployeeFound() throws Exception {
		when(es.getEmployee(1200)).thenThrow(new EmployeeNotFoundException("No Employee Found"));
		mvc.perform(MockMvcRequestBuilders.get("/employee/1200"))
		.andExpect(status().isNotFound())
		.andDo(print());
	}
	@Test
	void testUpdateEmployee() throws Exception {

		Employee e=new Employee(101,"subbu",10000);
		e.setEname("veera");
		es.update(e,101);
		when(es.update(e, 101)).thenReturn(e);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/employee/101")
	            .contentType("Application/json;charset=UTF-8")
	            .accept("Application/json")
	            .content(new ObjectMapper().writeValueAsString(e));
		mvc.perform(mockRequest)
		.andDo(print());
	}
	@Test
	void testUpdateEmployeeNotFound() throws Exception {

		Employee e=new Employee();
		//e.setEname("veera");
		es.update(e,102);
		when(es.update(e, 102)).thenThrow(new EmployeeNotFoundException("No Employee Found"));
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/employee/102")
	            .contentType("Application/json;charset=UTF-8")
	            .accept("Application/json")
	            .content(new ObjectMapper().writeValueAsString(e));
		mvc.perform(mockRequest)
		//.andExpect(status().isNotFound())
		.andDo(print());
	}
	
}
