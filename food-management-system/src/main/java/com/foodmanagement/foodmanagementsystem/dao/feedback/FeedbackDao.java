package com.foodmanagement.foodmanagementsystem.dao.feedback;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Customer;
import com.foodmanagement.foodmanagementsystem.model.Feedbacks;
import com.foodmanagement.foodmanagementsystem.model.Order;

@Repository
public interface FeedbackDao extends CrudRepository<Feedbacks, Long>{
	List<Feedbacks> findByOrderno(Long orderno);
	

}
