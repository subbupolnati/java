package com.book.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.book.Book;

public class BookDAO {
	HibernateTemplate template;//Dependency Injection
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	@Transactional
	public void insertBook(Book b)
	{
		template.save(b);
	}
	@Transactional
	public void updateBook(int bid,String nm)
	{
		Book b1=template.get(Book.class,bid);
		b1.setBname(nm);
		template.save(b1);
	}
	@Transactional
	public void deleteBook(int bid)
	{
		Book b1=template.get(Book.class, bid);
		template.delete(b1);
	}
}
