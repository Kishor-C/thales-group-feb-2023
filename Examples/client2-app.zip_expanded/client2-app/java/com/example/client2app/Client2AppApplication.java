package com.example.client2app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Client2AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Client2AppApplication.class, args);
	}
	
	// register the RestTemplate in spring container
	@LoadBalanced
	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}
}
