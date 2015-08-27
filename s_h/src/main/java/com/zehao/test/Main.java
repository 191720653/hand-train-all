package com.zehao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zehao.dao.IUserDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		IUserDao studentJDBCTemplate = (IUserDao) applicationContext.getBean("studentJDBCTemplate4");
		System.out.println("------Records creation--------");
//		studentJDBCTemplate.create("Zara", 11, 99, 2010);
//		studentJDBCTemplate.create("Nuha", 20, 97, 2010);
//		studentJDBCTemplate.create("Ayan", 25, 100, 2011);
	}

}
