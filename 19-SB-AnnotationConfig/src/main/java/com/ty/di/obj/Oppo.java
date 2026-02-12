package com.ty.di.obj;

import org.springframework.stereotype.Component;

@Component
public class Oppo implements Mobile {

	@Override
	public void call() {
		System.out.println("Oppo got a call");
	}

}
