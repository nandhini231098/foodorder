package com.foodmanagement.foodmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.dao.CustomerDao;
import com.foodmanagement.foodmanagementsystem.dao.CustomerMail;
import com.foodmanagement.foodmanagementsystem.dao.CustomerPaging;
import com.foodmanagement.foodmanagementsystem.dao.PagingDao;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;



@Service
@Transactional
public class CustomerImpl implements  CustomerService{
	@Autowired
	CustomerDao repos;
	
	@Autowired
	CustomerMail mail;
	
	@Autowired
	CustomerPaging dao;

	@Override
	public List<Customer> getAllcustomer() {
		return (List<Customer>) repos.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		return repos.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		repos.save(customer);
	}

	@Override
	public void deletecustomer(long id) {
		repos.deleteById(id);
	}

	@Override
	public Page<Customer> findPaginated(int pageNo, int pageSize) {
		 Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		 return this.dao.findAll(pageable);
		
	}

	@Override
	public Customer getcustomer(String name) {	
		return repos.findByName(name);
	}

	@Override
	public List<Customer> getbyid(Long customerid) {
	List<Customer> list=repos.findByCustomerid(customerid);
		return list;
	}

	

	


	

	

}
