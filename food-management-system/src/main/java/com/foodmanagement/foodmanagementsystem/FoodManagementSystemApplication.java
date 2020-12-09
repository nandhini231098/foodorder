package com.foodmanagement.foodmanagementsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FoodManagementSystemApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(FoodManagementSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FoodManagementSystemApplication.class, args);			
		
	
	
	}

	
	}

	


