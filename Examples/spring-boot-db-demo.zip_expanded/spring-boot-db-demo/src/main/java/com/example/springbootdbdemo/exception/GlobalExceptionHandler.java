package com.example.springbootdbdemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// a method that can handle RuntimeExceptions
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleExceptions(RuntimeException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("exceptionClass", ex.getClass().getName());
		map.put("exceptionMessage", ex.getMessage());
		return ResponseEntity.status(404).body(map);
	}
}
