package com.foodmanagement.foodmanagementsystem.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Customer;
@Repository
public interface CustomerPaging extends PagingAndSortingRepository<Customer, Long> {

}
