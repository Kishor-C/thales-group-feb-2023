package com.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Employee;
import com.service.EmployeeServiceImpl;

public class EmployeeViewController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeServiceImpl service = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
		Scanner scan = new Scanner(System.in); // to take input from keyboard using nextInt(), next(), nextDouble()
		System.out.println("Enter 1: Store 2: Find By Id 3: Find All");
		int option = scan.nextInt();
		if(option == 1) {
			Employee emp = new Employee();
			System.out.println("Enter name:-");
			emp.setName(scan.next());
			System.out.println("Enter salary:-");
			emp.setSalary(scan.nextDouble());
			int status = service.store(emp);
			System.out.println("Updated row: "+status);
		}
		if(option == 2) {
			System.out.println("Enter id:-");
			Employee e = service.fetchEmployee(scan.nextInt());
			System.out.println("Id = "+e.getId()+", Name = "+e.getName()+", Salary = "+e.getSalary());
		}
		if(option == 3) {
			List<Employee> list = service.fetchEmployees();
			list.stream()
			.forEach(e -> System.out.println("Id = "+e.getId()+", Name = "+e.getName()+", Salary = "+e.getSalary()));
		}
	}
}
