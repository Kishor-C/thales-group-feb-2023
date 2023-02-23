package com.example.springbootdbdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdbdemo.beans.Employee;
import com.example.springbootdbdemo.exception.EmployeeNotFoundException;
import com.example.springbootdbdemo.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
@CrossOrigin(origins = {"*"})
public class EmployeeRest {

	@Autowired
	private EmployeeService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Employee employee) {
		Employee emp = service.store(employee);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Hello "+emp.getName()+" created with an id "+emp.getId());
		return ResponseEntity.status(201).body(map);
	}
	@GetMapping
	public ResponseEntity<Object> getAllApi() {
		List<Employee> list = service.fetchEmployees();
		return ResponseEntity.status(200).body(list);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getApi(@PathVariable("id") int id) {
		try {
			Employee emp = service.fetchEmployee(id);
			return ResponseEntity.status(200).body(emp);
		} catch(EmployeeNotFoundException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteApi(@PathVariable("id") int id) { 
		try {
			service.deleteEmployee(id);
			return ResponseEntity.status(200).body("Deleted "+id+" Successfully");
		} catch(EmployeeNotFoundException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	@PutMapping(path = "/{id}/{name}")
	public ResponseEntity<Object> updateNameApi(@PathVariable("id") int id, @PathVariable("name") String name) { 
		try {
			Employee emp = service.updateName(id, name);
			return ResponseEntity.status(200).body(emp);
		} catch(EmployeeNotFoundException e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	
}
