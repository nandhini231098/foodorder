package com.foodmanagement.foodmanagementsystem.service.addToCart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;
@Service
public interface CartService {
	public void saveitems(CartItems item);
	
	public List<CartItems> getbycustomer (Customer details);
	
	public List<CartItems> deletebycustomer (Customer customer);
	
	public void deletebyid(Long cartid);
 	
	 public CartItems getCartById(Long cartid);

 	
}
