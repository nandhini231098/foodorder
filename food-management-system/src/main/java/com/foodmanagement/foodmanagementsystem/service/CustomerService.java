package com.foodmanagement.foodmanagementsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;



public interface CustomerService {
	
 public List<Customer> getAllcustomer();
 
	 public Customer getCustomerById(long id);
	 
	 public void saveOrUpdate(Customer customer);
	 
	 public void deletecustomer(long id);

	 Page <Customer> findPaginated(int pageNo, int pageSize);
	 
    Customer  getcustomer(String name);
    
    public List<Customer> getbyid(Long customerid);
	 
	
}
