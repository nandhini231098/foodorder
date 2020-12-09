package com.foodmanagement.foodmanagementsystem.controller.orders;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;
import com.foodmanagement.foodmanagementsystem.model.Order;
import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.addToCart.CartService;
import com.foodmanagement.foodmanagementsystem.service.items.ItemService;
import com.foodmanagement.foodmanagementsystem.service.orders.OrderService;

@Controller
public class OrderController {

	@Autowired
	ItemService itemService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CartService cartService;

	@Autowired
	OrderService orderService;

	@GetMapping("/order")
	public String orders() {
		return "orders";
	}

	@GetMapping(value = "/user/order")
	public String addcart(Principal principal) {
		
		Order orders=orderService.findbyorderNo();
		if(orders.getOrderno()==null ) {
			String name = principal.getName();
			Customer details = customerService.getcustomer(name);		
			List<CartItems> cartItems=cartService.getbycustomer(details);			
		Long ordernos=(long) 1;
		 for(CartItems cartList:cartItems) {		
				String itemname=cartList.getItemname();
				double price=cartList.getPrice();
				Long quantity=cartList.getQuantity();			
				Items item=cartList.getItem();				
				Order order = new Order( details,itemname,price,item,quantity,ordernos);			
				orderService.saveorder(order);						
				 
			}return ("redirect:/user/deletecart");
		}
		else {	
			String name = principal.getName();
			Customer details = customerService.getcustomer(name);		
			List<CartItems> cartItems=cartService.getbycustomer(details);		
			
			Long ordernos=orders.getOrderno();
			ordernos=ordernos+1;			
		
		
		 for(CartItems cartList:cartItems) {		
			String itemname=cartList.getItemname();
			double price=cartList.getPrice();
			Long quantity=cartList.getQuantity();			
			Items item=cartList.getItem();				
			Order order = new Order( details,itemname,price,item,quantity,ordernos);			
			orderService.saveorder(order);		
					 
		}
		
		 return ("redirect:/user/deletecart");
		
		}
	}
	
	@GetMapping(value = "/user/vieworder")
	  public String view(Model	model,Principal principal) {		
		  String name = principal.getName();
	        Customer details=customerService.getcustomer(name);  
	        List<Order> views=orderService.getbycustomer(details);
	        model.addAttribute("orderForms",views);
	        return "orders";		  
	  }
	
	@GetMapping("/user/deleteorder/{orderid}")	 
	public String delete(@PathVariable("orderid") Long orderid) { 
		System.out.println("orderid");
		orderService.deleteOrder(orderid);			
		return ("redirect:/user/vieworder");
	}
	
	@GetMapping(value = "/admin/vieworder/{customerid}")
	  public String adminview(Model	model,@PathVariable("customerid") Long  customerid) {	
		

		 Customer details=customerService.getCustomerById(customerid);
	        List<Order> views=orderService.getbycustomer(details);
	        model.addAttribute("adminOrder",views);
	        return "adminorders";		  
	  }

}
