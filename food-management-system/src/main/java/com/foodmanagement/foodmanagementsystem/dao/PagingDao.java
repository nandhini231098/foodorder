package com.foodmanagement.foodmanagementsystem.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;

@Repository
public interface PagingDao extends PagingAndSortingRepository<Items, Long>{

}
