package com.tyss;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	// API's
	@RequestMapping("/login")
	public String greet() {
		return "login.html";
	}

	@RequestMapping("/reg")
	public String registerPage() {
		System.out.println("Register Triggered");
		return "register.jsp";
	}

	// reading data from view

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		System.out.println("reading data");
		String name = request.getParameter("un");
		String email = request.getParameter("ue");
		String pwd = request.getParameter("pwd");

		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);

		return "Hello";// view name
	}

	// send the data to view so view can display it on the browser.
	// Model , ModelAndView

	@RequestMapping("/display")
	public String displayData(Model model) {
		System.out.println("API called");
		String name = "Penga";
		int age = 32;
		model.addAttribute("personName", name);
		model.addAttribute("personAge", age);
		User user = new User("Manga", "manga@gmail.com", "manga123", 34, "Thane", 3456789, "Male");
		model.addAttribute("userData", user);
		return "display.jsp";
	}
	@RequestMapping("/mv")
	public ModelAndView displayData() {
		System.out.println("API called");
		String name = "Pengi";
		int age = 33;
		User user = new User("Mangi", "mangi@gmail.com", "mangi123", 34, "Thane", 3456789, "Female");
		ModelAndView mv = new ModelAndView("display.jsp");
		//set the view
//		mv.setViewName("display.jsp");
		//set the model
		mv.addObject("personName", name);
		mv.addObject("personAge", age);
		mv.addObject("userData", user);
		return mv;
	}

}
