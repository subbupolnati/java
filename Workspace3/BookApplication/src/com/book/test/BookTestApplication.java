package com.book.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.book.bean.Book;
public class BookTestApplication {

	public static void main(String[] args) {
		Resource r=new ClassPathResource("/com/book/resource/Beans.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		Book b=(Book) bf.getBean("b");
		System.out.println("book id:"+b.getBid());
		System.out.println("book name:"+b.getBname());
		System.out.println("book price:"+b.getPrice());
		System.out.println("book author:"+b.toString());

	}

}
