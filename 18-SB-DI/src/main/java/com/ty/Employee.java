package com.ty;

public class Employee {

	String name;
	String email;
	double salary;

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void task() {
		System.out.println("employee is working on login task");
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		System.out.println("Salary : " + salary);
	}
}
