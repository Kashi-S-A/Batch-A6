package com.tyss.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tyss.service.EmailService;

import jakarta.mail.MessagingException;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/send")
	public String sendEmail(@RequestParam String email) {
		emailService.sendMail(email);
		return "Email Sent, check your email : " + email;
	}

	@GetMapping("/send-email")
	public String sendEmailWithTemplate(@RequestParam String email, @RequestParam String username)
			throws MessagingException, IOException {
		emailService.sendMailWithTemplate(email, username);
		return "Mail Sent";
	}

}
