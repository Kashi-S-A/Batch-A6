package com.ty.enums;

public class Driver {

	public static void main(String[] args) {
		Emp e = new Emp("dinga", 25, Role.ADMIN);
		e.display();

		System.out.println(Role.ADMIN);

		Role r = Role.USER;

		System.out.println(r);

	}
}
