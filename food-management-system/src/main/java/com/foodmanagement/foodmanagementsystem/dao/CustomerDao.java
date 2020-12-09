package com.foodmanagement.foodmanagementsystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Customer;
@Repository
public interface CustomerDao extends CrudRepository<Customer, Long>{	
	Customer findByName(String name);
	List<Customer> findByCustomerid (Long customerid);

}
