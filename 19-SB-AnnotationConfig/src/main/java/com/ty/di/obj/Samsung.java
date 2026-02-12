package com.ty.di.obj;

import org.springframework.stereotype.Component;

@Component
public class Samsung implements Mobile {

	@Override
	public void call() {
		System.out.println("Samsung mobile is getting call");
	}

}
