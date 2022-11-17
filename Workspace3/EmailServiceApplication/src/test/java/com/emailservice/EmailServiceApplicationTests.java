package com.emailservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.mail.MessagingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.emailservice.model.EmailDetails;
import com.emailservice.service.EmailService;

@SpringBootTest
class EmailServiceApplicationTests {

	
	EmailDetails email;
	EmailDetails e1;
	EmailService es=Mockito.mock(EmailService.class);
	ArrayList<EmailDetails> emailList=new ArrayList<EmailDetails>();
	@BeforeEach
	void init() {
		email=new EmailDetails("subbu.polnati719@gmail.com","helllo","hai","C:\\Workspace3\\EmailServiceApplication\\subbu_exp.pdf");
		e1=new EmailDetails("ramsai.jaddu7@gmail.com","testing mail","ramsai","C:\\Workspace3\\EmailServiceApplication\\subbu_exp.pdf");
		emailList.add(e1);
		emailList.add(email);
	}
	@Test
	void test1() {
		EmailDetails e=email;
		assertSame(e,email);
	}
	@Test
	void test2() {
	assertEquals(email,email);
	}
	@Test
	void test3() {
	assertEquals(email.getSubject(),"helllo");
	}
	@Test
	void test4() {
		assertSame("hai",email.getMsgBody());
	}
	@Test
	void test5() {
		assertNotNull(email.getSubject());
	}
	@Test
	void test6() {
		assertTrue(e1.getTo().equalsIgnoreCase("ramsai.jaddu7@gmail.com"));
	}
	@Test
	void test7() {
		assertFalse(e1.equals(email));
	}
	@Test
	void test8() {
		assertTrue(emailList.size()==2);
	}
	@Test
	void test9() {
		assertNotEquals(e1.getTo(),email.getTo());
	}
	@Test
	void test10() {
		assertNotNull(e1.getSubject());
	}
	@Test
	void test11() {
		when(es.sendMail(email)).thenReturn("email sent successfully");
	}
	@Test
	void test12() throws MessagingException {
		when(es.sendMailWithAttachment(email)).thenReturn("email sent successfully");
	}
	@Test
	void test13() {
		doReturn("email sent successfully").when(es).sendMail(email);
		}
	@Test
	void test14() throws MessagingException {
		doReturn("email sent successfully").when(es).sendMailWithAttachment(email);
		}
	@Test
	void test15()  {
		verify(es,never()).sendMail(email);
	}
	@Test
	void test16()  {
		es.sendMail(e1);
		verify(es,times(1)).sendMail(e1);
	}
	@Test
	void test17() {
		when(es.sendMail(e1)).thenReturn("email sent successfully");
		assertEquals("email sent successfully",es.sendMail(e1));
		verify(es,atLeast(1)).sendMail(e1);
	}
	@Test
	void test18() {
		when(es.sendMail(e1)).thenReturn("email sent successfully");
		assertEquals("email sent successfully",es.sendMail(e1));
		assertEquals("email sent successfully",es.sendMail(e1));
		assertEquals("email sent successfully",es.sendMail(e1));
		verify(es,atMost(3)).sendMail(e1);
	}
	@Test
	void test19() throws MessagingException {
		es.sendMailWithAttachment(email);
		verify(es,atLeastOnce()).sendMailWithAttachment(email);
	}
	@Test
	void test20()  {
		es.sendMail(email);
		verify(es,atMostOnce()).sendMail(email);
	}
	
}
