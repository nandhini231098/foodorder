package com.foodmanagement.foodmanagementsystem.controller.feedback;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmanagement.foodmanagementsystem.dao.CustomerDao;
import com.foodmanagement.foodmanagementsystem.dao.feedback.FeedbackDao;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Feedbacks;
import com.foodmanagement.foodmanagementsystem.model.Order;
import com.foodmanagement.foodmanagementsystem.model.customer.ConfirmationToken;
import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.feedback.FeedService;
import com.foodmanagement.foodmanagementsystem.service.mail.EmailService;
import com.foodmanagement.foodmanagementsystem.service.orders.OrderService;

@Controller
public class FeedController {
	
	@Autowired
	FeedService service;
	
	@Autowired
	FeedbackDao repos;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;

			@Autowired
			private CustomerDao dao;
			
			
	
	
	@GetMapping("/admin/feedback/{orderno}")
	public String list(@PathVariable ("orderno") Long orderno,Model model) {
		try{
			    
		List<Feedbacks> feedList=repos.findByOrderno(orderno);
		model.addAttribute("feedList", feedList);
		return "feedbackList";
		}catch (NullPointerException e) {
		return	"nullpage";
		}
	}
	
	
	
	 @GetMapping("/user/addfeed")
	 	 public ModelAndView additems( ModelAndView  model) {
				
		 Feedbacks feed = new Feedbacks();
		 model.addObject("feedForm", feed); 
		 model.setViewName("addFeed");	 
	  return model;
	  }
	 
	
	@PostMapping("/user/savefeed")
	public ModelAndView save(@ModelAttribute("feedForm") Feedbacks feedback,ModelAndView modelAndView,Principal principal) {	
		
		String feed=feedback.getFeedback();		
		 	String name = principal.getName();
	        Customer details=customerService.getcustomer(name);	 
	        Order order=orderService.findbyorderNo();  
	     Long orderno= order.getOrderno();
	     order.setOrderno(orderno);
	         Feedbacks feeds = new Feedbacks(feed,orderno,details); 
	         service.saveOrUpdate(feeds);
	       
		return new ModelAndView("redirect:/user/addfeed");
	}
	
		
	@GetMapping(value="/user/profile")	
	public String account(Model model,Principal principal) {
		String name = principal.getName();
        Customer details=customerService.getcustomer(name);	
        Long id=details.getId();
        List<Customer> list=customerService.getbyid(id);
		 model.addAttribute("profileForm", list);		    		 
		 return "account";
	 }	 
	 
	
	
	
}
