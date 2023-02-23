package com.example.springbootdbdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springbootdbdemo.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	// we can write our custom methods with JPQL
	
	@Query("select emp from Employee emp where emp.name = ?1")
	public List<Employee> findByName(String name);
}
