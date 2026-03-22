package com.tyss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

}
