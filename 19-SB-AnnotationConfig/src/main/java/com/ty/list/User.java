package com.ty.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class User {

	@Value(value = "Penga")
	String name;

	@Value(value = "34")
	int age;

	@Autowired
	List<String> addresses;

	@Autowired
	Adhar adhar;

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println("Addresses : " + addresses);
	}
}
