package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		Identifier identify = (Identifier)context.getBean("b1");
		identify.informations();
		DBSource ds = (DBSource)context.getBean("b2");
		System.out.println("Username = "+ds.getUsername());
		System.out.println("Password = "+ds.getPassword());
		System.out.println("URL = "+ds.getUrl());
		System.out.println("___________________________");
		TestDao dao = (TestDao)context.getBean("testDao");
		dao.store();
	}
}
