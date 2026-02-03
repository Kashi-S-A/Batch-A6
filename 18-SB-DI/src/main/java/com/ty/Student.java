package com.ty;

public class Student {

	String name;
	long phone;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, long phone) {
		this.name = name;
		this.phone = phone;
	}

	public void display() {
		System.out.println("----------Student-----------");
		System.out.println("Name : " + name);
		System.out.println("Phone : " + phone);
	}
}
