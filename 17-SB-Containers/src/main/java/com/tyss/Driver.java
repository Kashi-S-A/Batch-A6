package com.tyss;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver {

	public static void main(String[] args) {
		// core container
		Resource resource = new ClassPathResource("config.xml");// beans
		BeanFactory factory = new XmlBeanFactory(resource);// Core container

		Person person = (Person) factory.getBean("personId");
		person.run();
	}
}
