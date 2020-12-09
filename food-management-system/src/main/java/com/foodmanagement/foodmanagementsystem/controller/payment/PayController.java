package com.foodmanagement.foodmanagementsystem.controller.payment;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Order;
import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.addToCart.CartService;
import com.foodmanagement.foodmanagementsystem.service.items.ItemService;
import com.foodmanagement.foodmanagementsystem.service.orders.OrderService;

@Controller
public class PayController {
	@Autowired
	ItemService itemService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CartService cartService;

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/user/payment")
	public String paylist() {
		return "payment";
	}
	@GetMapping(value = "/user/viewpayment")
	  public String view(Model	model,Principal principal) {		
		  String name = principal.getName();
	        Customer details=customerService.getcustomer(name);  
	        List<CartItems> views=cartService.getbycustomer(details);
	        model.addAttribute("paymentForms",views);
	        return "payment";		  
	  }

}
