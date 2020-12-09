package com.foodmanagement.foodmanagementsystem.service.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.dao.feedback.FeedbackDao;
import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Feedbacks;
import com.foodmanagement.foodmanagementsystem.model.Order;

@Service
public class FeedImpl  implements FeedService {
	
	@Autowired
	FeedbackDao dao;

	@Override
	public void saveOrUpdate(Feedbacks feed) {		
		dao.save(feed);
	}

	@Override
	public List<Feedbacks> getAllfeed() {
		return (List<Feedbacks>) dao.findAll();
		
	}

	

	

	
	

}
