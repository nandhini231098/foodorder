package com.foodmanagement.foodmanagementsystem.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.foodmanagement.foodmanagementsystem.model.entity.AbstractAuditingEntity;

@Entity
@Table(name = "customer")
public class Customer extends AbstractAuditingEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;

	@Column(name = "customer_name")
	private String name;

	

	@Column(name = "password")
	private String password;

	@Column(name = "location")
	private String location;

	@Column(name = "Phone_no")
	private Long phone;

	@Column(name = "email_id")
	private String email;

	@Column(name= "role")
	@NotNull
	private String role="ROLE_USER";
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	@OneToMany(mappedBy = "customer")
	private List<Feedbacks> feedback;
	
	@OneToMany(mappedBy = "customer")
	private List<CartItems> cart;
	
	 /*@OneToOne(mappedBy = "customer")
	    private Order order;
	 
	 @OneToOne(mappedBy = "customer")
	    private Feedbacks feedback;*/	
	 private boolean isEnabled;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return customerid;
	}

	public void setId(Long customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	

}
