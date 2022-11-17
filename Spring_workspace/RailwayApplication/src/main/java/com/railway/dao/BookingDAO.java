package com.railway.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.railway.Train;

public class BookingDAO {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	@Transactional
	public void booking(Train t)
	{
		template.save(t);
	}
}
