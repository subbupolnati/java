package com.emp.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.emp.Employee;

public class EmployeeDAO {
	HibernateTemplate template;
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	@Transactional
	public void insertEmployee(Employee e) {
		template.save(e);
	}

}
