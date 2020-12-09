package com.foodmanagement.foodmanagementsystem.controller.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.foodmanagement.foodmanagementsystem.dao.cart.CartDao;
import com.foodmanagement.foodmanagementsystem.model.CartItems;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Items;
import com.foodmanagement.foodmanagementsystem.service.addToCart.CartService;
import com.foodmanagement.foodmanagementsystem.service.items.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	CartService cartService;
	@Autowired
	CartDao dao;

	@GetMapping("/items")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("item_list");
		List<Items> itemLists = itemService.getAllItems();
		model.addObject("itemList", itemLists);

		return model;
	}

	@GetMapping(value = "/user/items/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		int total = 5;
		if (pageid == 1) {
		} else {
			// pageid = (pageid - 1) * total + 1;
		}
		ModelAndView model = new ModelAndView("item_List");

		Page<Items> page = itemService.findPaginated(pageid, total);
		List<Items> list = page.getContent();
		model.addObject("itemList", list);
		return model;
	}
	
	@GetMapping(value = "/admin/items/{pageid}")
	public ModelAndView listing(@PathVariable int pageid) {
		int total = 6;
		if (pageid == 1) {
		} else {
			// pageid = (pageid - 1) * total + 1;
		}
		ModelAndView model = new ModelAndView("adminList");

		Page<Items> page = itemService.findPaginated(pageid, total);
		List<Items> list = page.getContent();
		model.addObject("cartList", list);
		return model;
	}

	@GetMapping("/admin/additem")
	public ModelAndView additems() {
		ModelAndView model = new ModelAndView();
		Items admins = new Items();
		model.addObject("itemForms", admins);
		model.setViewName("additem");
		return model;
	}
	
	@PostMapping("/admin/saveitem")
	public ModelAndView save(@ModelAttribute("itemForm") @RequestBody Items user,ModelAndView modelAndView) {		
		
		itemService.saveOrUpdate(user);

		return new ModelAndView("redirect:/admin/additem");
	}


}
