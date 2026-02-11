package com.ty.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	@Value(value = "500")
	int cc;

	public void start() {
		System.out.println("engine started");
	}
}
