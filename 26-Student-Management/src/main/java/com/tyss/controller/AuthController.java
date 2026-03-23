package com.tyss.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.dto.UserDto;
import com.tyss.entity.User;
import com.tyss.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserRepo userRepo;

	private final PasswordEncoder passwordEncoder;

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("register", new UserDto());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(UserDto userDto) {
		Optional<User> opt = userRepo.findByEmail(userDto.getEmail());

		if (opt.isPresent()) {
			return "redirect:/login?msg=already registered, please login!!!";
		}

		User user = new User();

		BeanUtils.copyProperties(userDto, user);

		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		userRepo.save(user);

		return "redirect:/login?msg=Registered Successfully";
	}

	@GetMapping("/login")
	public String loginPage(Model model, @RequestParam(required = false) String msg) {

		model.addAttribute("msg", msg);

		return "login";
	}

}
