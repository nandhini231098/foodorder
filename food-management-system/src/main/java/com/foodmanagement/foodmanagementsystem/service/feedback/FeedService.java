package com.foodmanagement.foodmanagementsystem.service.feedback;

import java.util.List;


import com.foodmanagement.foodmanagementsystem.model.Feedbacks;


public interface FeedService {
	 public void saveOrUpdate(Feedbacks feed);
	 public List<Feedbacks> getAllfeed();


}
