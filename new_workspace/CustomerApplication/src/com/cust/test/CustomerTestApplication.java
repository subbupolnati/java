package com.cust.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cust.bean.Customer;


public class CustomerTestApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r=new ClassPathResource("/com/cust/resource/Beans.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		Customer c =(Customer) bf.getBean("c");
		System.out.println("Customer id:"+c.getCid());
		System.out.println("Customer name:"+c.getCname());
		System.out.println("Customer Address:"+c.getAddress());
	}

}
