package com.foodmanagement.foodmanagementsystem.controller.cart;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodmanagement.foodmanagementsystem.FoodManagementSystemApplication;
import com.foodmanagement.foodmanagementsystem.dao.cart.CartDao;
import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;
import com.foodmanagement.foodmanagementsystem.model.Order;
import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.addToCart.CartService;
import com.foodmanagement.foodmanagementsystem.service.items.ItemService;
import com.foodmanagement.foodmanagementsystem.service.orders.OrderService;

import javassist.bytecode.stackmap.BasicBlock.Catch;
@Controller
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartDao dao;
	
	@Autowired
	OrderService orderService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FoodManagementSystemApplication.class);

	
	@GetMapping("/user/deleteitem/{cartid}")	 
	public String delete(@PathVariable("cartid") Long cartid) { 		
		cartService.deletebyid(cartid);			
		return ("redirect:/user/viewcart");
	}
	
	@GetMapping("/user/deletecart")	 
	public String delete(Principal principal) { 
		String name = principal.getName();
        Customer details=customerService.getcustomer(name); 
		cartService.deletebycustomer(details);	
		return ("redirect:/user/addfeed");
	}
	  @GetMapping(value = "/user/carts")
	  public String addcart( @RequestParam("itemid") Long itemid,Principal principal) {
		Items cartList= itemService.getitemsbyid(itemid);
		String itemname=cartList.getItemName();
		double price=cartList.getPrice();
		String name = principal.getName();
        Customer details=customerService.getcustomer(name); 
        Long quantity=(long) 1;
        CartItems carts=new CartItems(cartList,details,itemname,price,quantity);	   
	    cartService.saveitems(carts);
		/*
		 * Order order = new Order(carts,details,itemname,price,cartList);
		 * orderService.saveorder(order)
		 */;		
		 
		return ("redirect:/user/items/1");
	 }
	
	  @GetMapping(value = "/user/viewcart")
	  public String view(Model	model,Principal principal) {
		  try{
		  String name = principal.getName();
	        Customer details=customerService.getcustomer(name);  
	        List<CartItems> views=cartService.getbycustomer(details);
	        model.addAttribute("cartForms",views);
	        return "cart";
			
		} catch (Exception e) {		
			return "nullpage";
		}
	        
	  }
	  
	  @GetMapping("/user/updateQuantity/{cartid}")	
		public ModelAndView editArticles(@PathVariable("cartid") Long cartid) {
			ModelAndView model = new ModelAndView();
			CartItems cartItem = cartService.getCartById(cartid);			
			model.addObject("quantityForm",cartItem);
			model.setViewName("quantityPage");
			return model;
		}
	  
	  @PostMapping("/user/savequantity")
	  public ModelAndView save(@ModelAttribute("quantityForm")  CartItems cartItem) {
		  Long quantity=cartItem.getQuantity();	 
		  Long cartid=cartItem.getCartid(); 		 
		  CartItems cart=cartService.getCartById(cartid);		 
		cart.setQuantity(quantity);	
		  cartService.saveitems(cart);
		 return new ModelAndView("redirect:/user/viewcart");
		}
}

