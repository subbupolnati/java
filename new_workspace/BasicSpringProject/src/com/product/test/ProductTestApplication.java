package com.product.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.product.Product;

public class ProductTestApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r=new ClassPathResource("Beans.xml");
		BeanFactory bf=new  XmlBeanFactory(r);
		Product p=(Product) bf.getBean("p");
		System.out.println("Product Id:"+p.getPid());
		System.out.println("product Name:"+p.getPname());
		System.out.println("Product Price:"+p.getPrice());
	}

}
