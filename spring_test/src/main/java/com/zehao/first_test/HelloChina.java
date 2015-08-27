package com.zehao.first_test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloChina implements IHelloMessage {

	public String sayHello() {
		// TODO Auto-generated method stub
		System.out.println("HelloChina init");
		return "大家好!";
	}

	public void init() {
		System.out.println("Bean is going through init.");
	}

	public void destroy() {
		System.out.println("Bean will destroy now.");
	}

}
