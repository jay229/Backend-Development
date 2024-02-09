package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
//		Samosa samosa=(Samosa)context.getBean("s1");
//		System.out.println(samosa);
		
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
		Samosa samosa=(Samosa)context.getBean("s1");
		System.out.println(samosa);
		context.registerShutdownHook();

	}

}
