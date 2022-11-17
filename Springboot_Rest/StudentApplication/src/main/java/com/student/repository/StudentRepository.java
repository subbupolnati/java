package com.student.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepository extends CassandraRepository<Student,Integer> {

}
