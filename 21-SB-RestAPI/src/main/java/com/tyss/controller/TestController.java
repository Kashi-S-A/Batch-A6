package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@GetMapping("/greet") 
	public String greet() {
		return "Good Afternoon";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "This is RestAPI";
	}
	
}
