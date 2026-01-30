package com.tyss;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("configA.xml");

		Student student = (Student) app.getBean("studentBeanId");
		student.study();

		Person person = (Person) app.getBean("personId");
		person.run();
	}
}
