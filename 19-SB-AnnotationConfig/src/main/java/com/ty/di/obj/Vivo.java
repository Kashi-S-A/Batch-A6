package com.ty.di.obj;

import org.springframework.stereotype.Component;

@Component
public class Vivo implements Mobile {

	@Override
	public void call() {
		System.out.println("Vivo got call");
	}

}
