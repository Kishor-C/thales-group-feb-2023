package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee;
import com.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/v1") // http://localhost:8080/spring/v1
public class MyRestApi {

	@Autowired
	private EmployeeServiceImpl service;
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> store(@RequestBody Employee employee) {
		int status = service.store(employee);
		Map<String, String> map = new HashMap<String, String>();
		if(status > 0) {
			map.put("message", "Employee stored");
		} else {
			map.put("message", "Failed to store");
		}
		return map;
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> fetchEmployees() {
		return service.fetchEmployees();
	}
	
	// spring/v1/test
	@RequestMapping(path = "/test", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet() {
		return "Hello Rest";
	}
	@RequestMapping(path = "/test2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> greet2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "alex123");
		map.put("name", "Alex");
		map.put("salary", "25000");
		return map;
	}
}
