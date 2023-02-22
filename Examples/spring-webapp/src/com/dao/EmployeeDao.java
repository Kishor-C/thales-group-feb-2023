package com.dao;

import java.util.List;

import com.Employee;

public interface EmployeeDao {
	int save(Employee employee); // stores employee information and returns number rows affected
	List<Employee> findAll(); // runs select query and returns employee in List
	Employee findById(int id); // runs select query and returns employee or null based on id
}
