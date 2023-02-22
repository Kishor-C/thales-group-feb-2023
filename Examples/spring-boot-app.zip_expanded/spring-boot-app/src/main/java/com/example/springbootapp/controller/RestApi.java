package com.example.springbootapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapp.config.Message;

@RestController
@RequestMapping("/v1")
public class RestApi {

	@Autowired
	private Message message;
	
	@GetMapping(path = "/test")
	public ResponseEntity<Object> greet() {
		double random = Math.random(); // between 0 to 1 i.e., 0.01349834 or 0.3923939
		ResponseEntity<Object> response = null;
		if(random > 0.5) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "This is a success message");
			map.put("random_number", ""+random);
			response = ResponseEntity.status(200).body(map);
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", "Sorry some data is not found");
			map.put("random_number", ""+random);
			response = ResponseEntity.status(404).body(map);
		}
		return response;
	}
}
