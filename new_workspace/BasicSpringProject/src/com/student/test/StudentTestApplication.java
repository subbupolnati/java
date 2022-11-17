package com.student.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.emp.Employee;
import com.student.Student;

public class StudentTestApplication {

	public static void main(String[] args) {
		Resource r=new ClassPathResource("Beans.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		Student s=(Student) bf.getBean("s");
		System.out.println("student Id="+s.getSid());
		System.out.println("Sudnet Name="+s.getSname());
		System.out.println("marks="+s.getMarks());

	}

}
