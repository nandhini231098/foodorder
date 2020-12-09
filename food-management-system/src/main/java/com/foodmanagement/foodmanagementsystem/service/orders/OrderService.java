package com.foodmanagement.foodmanagementsystem.service.orders;

import java.util.List;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Order;

public interface OrderService {

	public void saveorder(Order order);
	
	public void deleteOrder(Long orderid);
	
	public List<Order> getbycustomer (Customer details);
	
	public Order findbyorderNo();
}
