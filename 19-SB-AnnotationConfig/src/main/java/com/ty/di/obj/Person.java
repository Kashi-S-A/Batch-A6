package com.ty.di.obj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value(value = "Dinga")
	String name;

	@Value(value = "24")
	int age;

	@Autowired
	@Qualifier(value = "samsung")
	Mobile mobile;

	public void details() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		mobile.call();
	}
}
