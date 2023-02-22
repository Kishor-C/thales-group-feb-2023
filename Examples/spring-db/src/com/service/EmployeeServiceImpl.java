package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDao dao;
	// can throw EmployeeCreationFailedException if status is 0
	public int store(Employee employee) {
		return dao.save(employee);
	}
	
	public Employee fetchEmployee(int id) {
		return dao.findById(id);
	}
	public List<Employee> fetchEmployees() {
		return dao.findAll();
	}
}
