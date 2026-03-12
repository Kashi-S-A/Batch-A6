package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/user/greet") // ADMIN,USER
	public String greet() {
		return "Good Afternoon";
	}

	@GetMapping("/admin/msg") // ADMIN
	public String msg() {
		return "Welcome to Spring Security";
	}

	@GetMapping("/public/reg")
	public String reg() {
		return "Register Here";
	}

}
