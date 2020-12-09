package com.foodmanagement.foodmanagementsystem.service.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.dao.order.OrderDao;
import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Order;

@Service
public class OrderImpl implements OrderService{
	@Autowired
	OrderDao dao;

	@Override
	public void saveorder(Order order) {		
		dao.save(order);
	}

	@Override
	public void deleteOrder(Long orderid) {
		dao.deleteById(orderid);
		
	}

	@Override
	public List<Order> getbycustomer(Customer details) {
		List<Order> list=dao.findByCustomer(details);
		return list;
	}

	@Override
	public Order findbyorderNo() {
		
		return dao.findTopByOrderByOrdernoDesc();
	}

}
