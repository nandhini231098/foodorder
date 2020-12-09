package com.foodmanagement.foodmanagementsystem.schedule;


import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.mail.EmailService;

import reactor.core.scheduler.Scheduler;



@Component
public class ScheduleTasks {
	@Autowired
	CustomerService  customerService;
	@Autowired
	private EmailService emailService;
	
	   private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
	    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 
	 @Scheduled(cron = "0 12 * * * ?")
	   public void task() {
	   	 log.info("Current Time      = {}", dateFormat.format(new Date()));
		 log.info("Good Noon");
		 
	 }
	 
	

		@Scheduled(cron="0 15 8 ? * *")	
		public void messagemorning() {
			System.out.println("work");
			List<Customer> customerLists = customerService.getAllcustomer();
			for (Customer customer:customerLists){
				SimpleMailMessage mailMessage = new SimpleMailMessage();
		        mailMessage.setTo(customer.getEmail());
		        mailMessage.setSubject("Good Morning");
		        mailMessage.setFrom("nandymano123@gmail.com");
		        mailMessage.setText("Have a cup of Tea/coffee with Hot&spicy order");
		        emailService.sendEmail(mailMessage);
			}
		}

	 	@Scheduled(cron="0 0 12 * * ?")	
		public void messagenoon() {
			System.out.println("work");
			List<Customer> customerLists = customerService.getAllcustomer();
			for (Customer customer:customerLists){
				SimpleMailMessage mailMessage = new SimpleMailMessage();
		        mailMessage.setTo(customer.getEmail());
		        mailMessage.setSubject("Good Noon");
		        mailMessage.setFrom("nandymano123@gmail.com");
		        mailMessage.setText("Its Time to Fill Your Tummy with Your Favourite Meal");
		        emailService.sendEmail(mailMessage);
			}

			
	        
	 	}        
	}
	 


