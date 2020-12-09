package com.foodmanagement.foodmanagementsystem.service.addToCart;



import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.foodmanagement.foodmanagementsystem.dao.cart.CartDao;
import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;



@Service
@Transactional
public class CartImpl implements CartService {
@Autowired
CartDao dao;

	@Override
	public void saveitems(CartItems cart) {		
		dao.save(cart);
		
	}

	

	@Override
	public List<CartItems> getbycustomer(Customer details) {
		List<CartItems> view=dao.findByCustomer(details);
		return view;
	}



	@Override
	public void deletebyid(Long cartid) {
		dao.deleteById(cartid);
		
		
	}



	@Override
	public CartItems getCartById(Long cartid) {		
		return dao.findById(cartid).get();
	}



	@Override
	public List<CartItems> deletebycustomer(Customer customer) {
		List<CartItems> list=dao.deleteByCustomer(customer);
		return list;
	}
	
	
	


	
	
	
	

}
