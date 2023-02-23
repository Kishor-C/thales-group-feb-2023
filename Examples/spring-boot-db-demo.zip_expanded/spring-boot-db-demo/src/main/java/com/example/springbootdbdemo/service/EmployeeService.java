package com.example.springbootdbdemo.service;

import java.util.List;


import com.example.springbootdbdemo.beans.Employee;
import com.example.springbootdbdemo.exception.EmployeeNotFoundException;

public interface EmployeeService {

	Employee store(Employee employee);

	List<Employee> fetchEmployees();
	
	Employee fetchEmployee(int id) throws EmployeeNotFoundException;
	
	List<Employee> fetchEmployeesByName(String name); 

	void deleteEmployee(int id) throws EmployeeNotFoundException;
	
	Employee updateName(int id, String name) throws EmployeeNotFoundException;
}