package com.foodmanagement.foodmanagementsystem.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {
	private JavaMailSender javamail;
	
	@Autowired
	public EmailService(JavaMailSender javamail) {
		this.javamail=javamail;
	}
	@Async
	public void sendEmail(SimpleMailMessage email) {
		javamail.send(email);
	}
	

}
