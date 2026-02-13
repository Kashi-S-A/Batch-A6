package com.ty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ty.list.Adhar;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class AppConfig {

	@Bean
	public List<String> getAddresses() {

//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Tnane");
//		list.add("Mumbra");
//		
//		return list;

		return Arrays.asList("Thane", "Mumbra", "Bandra");
	}

	@Bean(value = "adharBean")
	@Scope(value = "prototype")
	public Adhar getAdhar() {
		return new Adhar();
	}
}
