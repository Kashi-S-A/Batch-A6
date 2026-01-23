package com.ty.enums;

public class Emp {

	private String name;
	private int age;
	private Role role;

	public Emp(String name, int age, Role role) {
		this.name = name;
		this.age = age;
		this.role = role;
	}

	public void display() {
		System.out.println("------Employee-----");
		System.out.println("Name : " + name);
		System.out.println("Age  : " + age);
		System.out.println("Role : " + role);
	}
}
