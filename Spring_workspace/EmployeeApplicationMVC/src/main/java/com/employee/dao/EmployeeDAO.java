package com.employee.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.employee.mapper.EmployeeMapper;
import com.employee.model.Employee;

public class EmployeeDAO {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void saveEmployee(Employee e) {
		String sql="insert into employee1 values("+e.getEmpid()+",'"+e.getEname()+"','"+e.getSalary()+"','"+e.getDesignation()+"')";
		template.update(sql);
	}
	public void updateEmploye(Employee e) {
		String sql="update employee1 set ename='"+e.getEname()+"',salary='"+e.getSalary()+"',designation='"+e.getDesignation()+"' where empid="+e.getEmpid();
		template.update(sql);
	}
	public void deleteEmploye(int empid) {
		String sql="delete from employee1 where empid="+empid;
		template.update(sql);
	}
	public List<Employee> seletedEmploye(int empid) {
		String sql="select * from employee1 where empid="+empid;
		return template.query(sql,new EmployeeMapper());
	}
	public List<Employee> getDetails(){
		String sql="select * from employee1";
		return template.query(sql,new EmployeeMapper());
	}

}
