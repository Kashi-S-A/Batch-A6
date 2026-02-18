package com.tyss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	// API's
	@RequestMapping("/login")
	public String greet() {
		return "login.html";
	}

	@RequestMapping("/reg")
	public String msg() {
		System.out.println("Register Triggered");
		return "register.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		System.out.println("reading data");
		String name = request.getParameter("un");
		String email = request.getParameter("ue");
		String pwd = request.getParameter("pwd");

		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);

		return "Hello";
	}

}
