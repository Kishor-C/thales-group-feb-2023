package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; // DMDS -> JT -> DAO
	
	@Override
	public int save(Employee employee) { // save is called by service by passing employee object
		String insertQuery = "insert into employee values(next value for emp_seq, ?, ?)";
		int status = jdbcTemplate.update(insertQuery, employee.getName(), employee.getSalary());
		return status;
	}

	@Override
	public List<Employee> findAll() {
		// use select query and use the same EmployeeMapper that will help you to 
		// create the List<Employee>, use jdbcTemplate.query(...)
		// in main method display all the employee details
		List<Employee> list = jdbcTemplate.query("select * from employee", 
				(rs, rowNum) -> new Employee(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("SALARY")));
		return list;
	}

	@Override
	public Employee findById(int id) {
		String selectQuery = "select * from employee where ID = ?";
		Employee emp = jdbcTemplate.queryForObject(selectQuery, 
				(rs, rowNum) -> new Employee(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("SALARY")), id);
		return emp;
	}

}
