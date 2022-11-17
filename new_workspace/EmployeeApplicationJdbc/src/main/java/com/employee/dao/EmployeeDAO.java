package com.employee.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.employee.bean.Employee;
import com.employee.bean.EmployeeMapper;

public class EmployeeDAO {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void saveEmployee(Employee e) {
		String sql="insert into employee values("+e.getEmpid()+",'"+e.getEname()+"','"+e.getSalary()+"')";
		template.update(sql);
	}
	public void updateEmploye(Employee e) {
		String sql="update employee set ename='"+e.getEname()+"',salary="+e.getSalary()+" where empid="+e.getEmpid();
		template.update(sql);
	}
	public void deleteEmploye(Employee e) {
		String sql="delete from employee where empid="+e.getEmpid();
		template.update(sql);
	}
	public List<Employee> getDetails(){
		String sql="select * from employee";
		return template.query(sql,new EmployeeMapper());
	}
	
}
