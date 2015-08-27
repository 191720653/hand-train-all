package com.zehao.first_test;

public class Person {
	
	private IHelloMessage iHelloMessage;

	public IHelloMessage getiHelloMessage() {
		return iHelloMessage;
	}

	public void setiHelloMessage(IHelloMessage iHelloMessage) {
		this.iHelloMessage = iHelloMessage;
	}
	
	public String sayHello(){
		return this.iHelloMessage.sayHello();
	}

}
