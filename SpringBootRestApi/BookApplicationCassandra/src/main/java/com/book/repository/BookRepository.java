package com.book.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.book.model.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book, Integer>{

	
}
