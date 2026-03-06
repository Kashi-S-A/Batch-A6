package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/exc")
	public String m1() {

		System.out.println("got the request");

//		String s = null;
//
//		System.out.println(s.charAt(10));

		int a = 10/0;

		return "Thank you for calling Test API";
	}
}
