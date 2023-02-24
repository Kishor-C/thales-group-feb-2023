package com.example.client2app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.client2app.beans.ReusableClient;
import com.example.client2app.beans.Transaction;

@RequestMapping("/upi")
@RestController
public class UpiController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ReusableClient client;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> fetchBalance(@PathVariable("id") long num) {
		//String url = "http://CLIENT-ONE/account/"+num;
		//Transaction tx = restTemplate.getForObject(url, Transaction.class);
		Transaction tx = client.getBalance(num);
		return ResponseEntity.status(200).body(tx);
	}
}
