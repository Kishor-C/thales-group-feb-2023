package com.example.client1app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getBalance(@PathVariable("id") long num) {
		System.out.println("_____Server port: "+port+"_____");
		double balance = (num * Math.random()) * 5;
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("balance", balance);
		map.put("port", Double.parseDouble(port));
		return ResponseEntity.status(200).body(map);
	}
}
