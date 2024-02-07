package com.springcore.springcore_basic.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/springcore_basic/collections/collectionsConfig.xml");
	        Employee emp=(Employee) context.getBean("emp1");
	        System.out.println(emp);

	}

}
