package com.example.springbootdbdemo.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String error) {
		super(error);
	}
	// you can throw as throw new EmployeeNotFoundException("some error message")
	// in the catch block you can use that error message using ex.getMessage();
}
