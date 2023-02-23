package com.example.springbootdbdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootdbdemo.beans.Employee;
import com.example.springbootdbdemo.dao.EmployeeRepository;
import com.example.springbootdbdemo.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired // spring container injects the implemented EmployeeRepository
	private EmployeeRepository repo;
	// implement some operations like store, fetchById, fetchAll, update, delete
	
	@Override
	@Transactional // required only on insert, update & delete
	public Employee store(Employee employee) {
		Employee emp = repo.save(employee); // save takes care of running insert/update query
		return emp;
	}
	
	@Override
	public List<Employee> fetchEmployees() {
		return repo.findAll(); // run select query and all records will be added to List
	}

	@Override
	public Employee fetchEmployee(int id) throws EmployeeNotFoundException {
		Employee e = repo.findById(id).orElse(null); // returns employee object or null;
		if(e == null) {
			throw new EmployeeNotFoundException("Employee with an id: "+id+" not found");
		}
		return e;
	}

	@Override
	public List<Employee> fetchEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Transactional
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Employee emp = fetchEmployee(id);
		repo.delete(emp);
	}

	@Transactional
	public Employee updateName(int id, String name) throws EmployeeNotFoundException {
		Employee emp = fetchEmployee(id);
		emp.setName(name);
		repo.save(emp);
		return emp;
	} // from the controller call this using @PutMapping("{id}/{name}")
	
	
}
