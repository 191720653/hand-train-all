package com.zehao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zehao.entity.Users;
import com.zehao.service.IUserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		IUserService iUserService = (IUserService) applicationContext.getBean("UserService");
		System.out.println("------Records creation--------");
		Users user = new Users();
		user.setAddress("Guangzhou city");
		user.setName("zehao");
		user.setPassword("123");
//		iUserService.save(user);
		System.out.println(iUserService.add(user));
		;
	}

}
