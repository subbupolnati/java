package com.book.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.book.bean.Book;

public class BookDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void saveBook(Book book) {
		String sql="insert into book1 values("+book.getBid()+",'"+book.getBname()+"')";
		template.update(sql);
	}

}
