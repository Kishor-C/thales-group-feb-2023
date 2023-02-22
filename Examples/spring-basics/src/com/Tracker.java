package com;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Tracker {
	
	private static Logger LOG = Logger.getLogger(Tracker.class.getName());
	
	@Before("execution(public  com.*.*(..))")
	public void logStore() {
		LocalDateTime time = LocalDateTime.now();
		LOG.info("------logStore()------");
		LOG.info(time.toString());
	}
	// Try @After on the same store() method 
}
