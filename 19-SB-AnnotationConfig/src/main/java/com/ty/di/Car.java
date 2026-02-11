package com.ty.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value(value = "XYZ")
	String brand;

//	@Autowired // variable or field
	Engine engine;

//	@Autowired // setter injection
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

//	@Autowired // constructor injection
	public Car(@Autowired Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		System.out.println("Brand : " + brand);
		System.out.println("cc : " + engine.cc);
		engine.start();
		System.out.println("ready to gooo!!!!!!");
	}
}
