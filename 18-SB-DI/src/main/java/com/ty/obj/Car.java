package com.ty.obj;

public class Car {

	String brand;

	Engine engine;// null, instance of engine

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		System.out.println("Brand : " + brand);
		System.out.println("cc : " + engine.cc);
		engine.start();
		System.out.println("Car started running");
	}
}
