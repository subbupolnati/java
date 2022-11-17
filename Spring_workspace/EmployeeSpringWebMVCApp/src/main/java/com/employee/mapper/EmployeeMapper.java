package com.employee.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.model.Employee;
public class EmployeeMapper implements RowMapper {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee e1=new Employee();
			e1.setEmpid(rs.getInt(1));
			e1.setEname(rs.getString(2));
			e1.setSalary(rs.getInt(3));
			e1.setDesignation(rs.getString(4));
			return e1;
		}	
	}

