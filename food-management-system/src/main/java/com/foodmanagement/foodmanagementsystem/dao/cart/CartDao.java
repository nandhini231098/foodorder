package com.foodmanagement.foodmanagementsystem.dao.cart;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;
import com.sun.mail.imap.protocol.Item;
@Repository
public interface CartDao extends CrudRepository<CartItems, Long> {
 //List<CartItems> findByCustomer (String name);

List<CartItems> findByCustomer(Customer details);

List<CartItems> deleteByCustomer (Customer customer);

}
