package com.ty.list;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.AppConfig;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = app.getBean(User.class);
		user.display();
		user.adhar.info();

		System.out.println("-------------");

		Adhar adhar = (Adhar) app.getBean("adharBean");
		adhar.info();
	}
}
