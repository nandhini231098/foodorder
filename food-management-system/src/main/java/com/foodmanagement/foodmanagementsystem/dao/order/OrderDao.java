package com.foodmanagement.foodmanagementsystem.dao.order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, Long>{

	List<Order> findByCustomer (Customer customer);
	
	Order  findTopByOrderByOrdernoDesc();

}
