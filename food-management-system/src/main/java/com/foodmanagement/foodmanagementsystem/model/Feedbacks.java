package com.foodmanagement.foodmanagementsystem.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.foodmanagement.foodmanagementsystem.model.entity.AbstractAuditingEntity;

@Entity
@Table(name = "feedback")
public class Feedbacks extends AbstractAuditingEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	
	
	@Column(name = "feedbacks")
	private String feedback ;
	
	
	@Column(name = "orderno")
	private Long orderno ;
	
	
	

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	

	public Feedbacks(Customer customer,String feedback) {
		
		this.customer = customer;
		this.feedback=feedback;
	}

	public Feedbacks( String feedback,Long orderno,Customer customer) {		
		this.feedback = feedback;
		this.customer = customer;
	
		this.orderno = orderno;
	}

	public Long getOrderno() {
		return orderno;
	}

	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}

	public Feedbacks() {
		
	}

	public Long getfeedbackid() {
		return feedbackId;
	}

	public void setfeedbackid(Long feedbackid) {
		this.feedbackId = feedbackid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
	 
	
}
