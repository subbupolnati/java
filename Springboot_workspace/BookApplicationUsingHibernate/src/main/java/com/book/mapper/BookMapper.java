package com.book.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.model.Book;

public class BookMapper implements RowMapper {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b1=new Book();
		b1.setBid(rs.getInt(1));
		b1.setBname(rs.getString(2));
		b1.setPrice(rs.getInt(3));
		return b1;
	}	

}
