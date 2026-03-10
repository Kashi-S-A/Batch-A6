package com.tyss.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String toEmail) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(toEmail);
		message.setSubject("Welcome to EmailService app");
		message.setText("Hello, Thank you for using our application, your account is registered successfully,"
				+ "Enjoy the services");

		javaMailSender.send(message);

	}

	public void sendMailWithTemplate(String toEmail, String username) throws MessagingException, IOException {
		
		String body = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/email-template.html")));
		
		body = body.replace("${app_name}", "EmailServiceApp")
		.replace("${username}", username)
		.replace("${app_link}", "#");

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo(toEmail);
		helper.setSubject("Thank you for Registering!!!!!!!!");
		helper.setText(body, true);// body contains the html code
		
		javaMailSender.send(message);

	}

}
