package com.zehao.first_test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/helloMessage.xml");

		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

		System.out.println(objA.toString());

		SubHelloWorld objB = (SubHelloWorld) context.getBean("subHelloWorld");
		System.out.println(objB.toString());

		// HelloChina obj = (HelloChina) context.getBean("helloChina");
		// obj.sayHello();
		// context.registerShutdownHook();

		// Resource resource = new
		// FileSystemResource("src/main/resources/spring/helloMessage.xml");
		// BeanFactory factory = new XmlBeanFactory(resource);
		// Person person = (Person) factory.getBean("person");
		// String word = person.sayHello();
		// System.out.println("This person is currently saying: " + word);
	}

}
