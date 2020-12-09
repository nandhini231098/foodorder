package com.foodmanagement.foodmanagementsystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Customer;

@Repository
public interface CustomerMail extends CrudRepository<Customer, String> {
	Customer findByEmailIgnoreCase(String email);
	List<Customer> findByEmail(String email);

}
