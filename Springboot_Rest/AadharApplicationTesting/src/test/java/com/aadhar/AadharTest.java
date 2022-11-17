package com.aadhar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.aadhar.model.Aadhar;
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class AadharTest {

	@Autowired
	TestRestTemplate template;
	
	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */
	@Test
	public void getAadhar() {
		String url="http://localhost:8080/aadhar?";
		HttpEntity<String> request=new HttpEntity<String>;
		UriComponents builder= UriComponentsBuilder.fromHttpUrl(url).queryParam("aid","817143772109").build();
		ResponseEntity<Aadhar> res=template.exchange(builder.toString(), HttpMethod.GET,Aadhar.class);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}
}
