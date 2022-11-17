package com.bank.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bank.bean.Bank;


public class BankTestApplication {

	public static void main(String[] args) {
		Resource r=new ClassPathResource("/com/bank/resource/Beans.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		Bank ba=(Bank) bf.getBean("ba");
		System.out.println("bank account no:"+ba.getAcno());
		System.out.println("balance:"+ba.getBal());
		System.out.println("deposit :"+ba.getDep());
	}

}
