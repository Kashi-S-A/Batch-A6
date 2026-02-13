package com.ty.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//variable or field injection
//@Component
public class Person {

	@Value(value = "Penga")
	String name;

	@Value(value = "18")
	int age;

	public void details() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}

	public void read() {
		System.out.println("Person is reading the book");
	}
}
