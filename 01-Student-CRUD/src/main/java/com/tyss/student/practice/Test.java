package com.tyss.student.practice;

public class Test {

	public static void main(String[] args) {
		System.out.println("main start");

		Demo obj = Utils.getDemo();
		String msg = obj.greet();
		System.out.println(msg);

		System.out.println("main end");
	}
}
