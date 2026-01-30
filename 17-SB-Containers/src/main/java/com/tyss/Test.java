package com.tyss;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Person person = (Person) app.getBean("bean1");
		person.run();

		Student student = (Student) app.getBean("bean1");
		student.study();
	}
}
