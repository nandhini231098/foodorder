package com.foodmanagement.foodmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.foodmanagement.foodmanagementsystem.dao.CustomerMail;
import com.foodmanagement.foodmanagementsystem.dao.Tokens;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.customer.ConfirmationToken;

import com.foodmanagement.foodmanagementsystem.service.CustomerService;
import com.foodmanagement.foodmanagementsystem.service.mail.EmailService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	private BCryptPasswordEncoder passwordsEncoder=new BCryptPasswordEncoder();
	
@Autowired
private EmailService emailService;

@Autowired
private Tokens confirm;

@Autowired
private CustomerMail dao;

private static final Logger log=LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/admin/viewcustomer")
	public ModelAndView viewlist() {
		ModelAndView model = new ModelAndView("viewlist");
		List<Customer> customerLists = customerService.getAllcustomer();
		model.addObject("adminCustomer", customerLists);
		return model;
	}
	
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	 
	@GetMapping("/welcome")
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}

	

	@GetMapping("/login")
	public ModelAndView userlogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();

		if (error != null) {
			model.addObject("error", "Username or Password is incorrect !!");
		}
		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}
		model.setViewName("login");
		return model;
	}

	


	@GetMapping("/admin/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("customer_list");
		List<Customer> customerLists = customerService.getAllcustomer();
		model.addObject("customerList", customerLists);

		return model;
	}
	
	
	
	
	
	@GetMapping("/register")
	public ModelAndView addcustomer() {
		ModelAndView model = new ModelAndView();

		Customer user = new Customer();
		model.addObject("registers", user);
		model.setViewName("register");
		log.trace("This is trace message");
		 log.debug("This is a DEBUG log");
	        log.info("This is an INFO log");
	        log.error("This is an ERROR log");
		return model;
	}

	@GetMapping("/success")
	public ModelAndView successing() {
		return new ModelAndView("success");
	}
	

	@GetMapping("/addcustomer")
	public ModelAndView addArticle() {
		ModelAndView model = new ModelAndView();

		Customer user = new Customer();
		model.addObject("customerForm", user);
		model.setViewName("customer_form");

		return model;
	}

	
	@GetMapping("/user/updatecustomers/{id}")	
	public ModelAndView editArticles(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();

		Customer article = customerService.getCustomerById(id);
		model.addObject("editForm", article);
		model.setViewName("customer_form");

		return model;
	}
	
	@PostMapping("/save")	
	public ModelAndView saving(@ModelAttribute("registers") @RequestBody Customer user,ModelAndView modelAndView) {
		String encodedPassword = passwordsEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
       // customerService.saveOrUpdate(user);
		Customer existinguser = dao.findByEmailIgnoreCase(user.getEmail());
		 if(existinguser != null)
	        {
	            modelAndView.addObject("message","This email already exists!");
	            modelAndView.setViewName("error");
	        }
		  else
	        {
			  customerService.saveOrUpdate(user);

	            ConfirmationToken confirmationToken = new ConfirmationToken(user);

	            confirm.save(confirmationToken);

	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	            mailMessage.setTo(user.getEmail());
	            mailMessage.setSubject("Complete Registration!");
	            mailMessage.setFrom("nandymano123@gmail.com");
	            mailMessage.setText("To confirm your account, please click here :"
	            +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());

	            emailService.sendEmail(mailMessage);

	            modelAndView.addObject("emailId", user.getEmail());

	            modelAndView.setViewName("verification");
	        }


		return modelAndView;
	}
	 
	
	@PostMapping("/user/savecustomer")
	public ModelAndView save(@ModelAttribute("editForm") @RequestBody  Customer user,ModelAndView modelAndView) {
		
		
		customerService.saveOrUpdate(user);

		return new ModelAndView("redirect:/user/profile");
	}

	@GetMapping("/admin/deletecustomer/{id}")	 
	public ModelAndView delete(@PathVariable("id") long id) {
		customerService.deletecustomer(id);

		return new ModelAndView("redirect:/admin/list/1");
	}

	@GetMapping(value = "/admin/list/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		int total = 7;
		if (pageid == 1) {
		} else {
			//pageid = (pageid - 1) * total + 1;
		}
		ModelAndView model = new ModelAndView("customer_list");

		Page<Customer> page = customerService.findPaginated(pageid, total);
		  List < Customer > list = page.getContent();
		model.addObject("customerList", list);
		return model;
	}
	
	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirm.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
           Customer user = dao.findByEmailIgnoreCase(token.getCustomer().getEmail());
            user.setEnabled(true);
            customerService.saveOrUpdate(user);
            modelAndView.setViewName("accountverified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
	
	@RequestMapping("/accessdenied")
	public ModelAndView accessdenied() {
		return new ModelAndView("accessdenied");
	}


	

}
