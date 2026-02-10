package com.ty.listobj;

public class Subject {
	
	int id;
	String name;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Id : " + id);
		System.out.println("Name : " + name);
		System.out.println("----------");
	}
}