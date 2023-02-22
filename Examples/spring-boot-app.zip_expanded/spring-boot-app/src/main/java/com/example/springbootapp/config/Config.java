package com.example.springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"beans.xml"})
public class Config {

//	@Bean
//	public Message createMessage() {
//		Message msg = new Message();
//		msg.setInformation("some information");
//		return msg;
//	}
}
