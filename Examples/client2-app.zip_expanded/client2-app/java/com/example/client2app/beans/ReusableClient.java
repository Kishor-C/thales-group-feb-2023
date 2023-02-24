package com.example.client2app.beans;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("http://CLIENT-ONE/")
public interface ReusableClient {

	@GetMapping("/account/{num}")
	public Transaction getBalance(@PathVariable("num") long num);
}
