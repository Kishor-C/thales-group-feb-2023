package com.example.springbootapp2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RestApi {

	@GetMapping(path = "/test")
	public String greet() {
		return "Hello Spring Boot!";
	}
}
