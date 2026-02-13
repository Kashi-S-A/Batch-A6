package com.ty.list;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.AppConfig;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		User user = app.getBean(User.class);
		System.out.println(user);

		User user1 = app.getBean(User.class);
		System.out.println(user1);

		User user2 = app.getBean(User.class);
		System.out.println(user2);

		Adhar a1 = app.getBean(Adhar.class);
		System.out.println(a1);
		
		Adhar a2 = app.getBean(Adhar.class);
		System.out.println(a2);
		
		Adhar a3 = app.getBean(Adhar.class);
		System.out.println(a3);
	}
}
