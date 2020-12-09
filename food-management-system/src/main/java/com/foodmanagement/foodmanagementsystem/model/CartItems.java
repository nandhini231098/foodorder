package com.foodmanagement.foodmanagementsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.foodmanagement.foodmanagementsystem.model.entity.AbstractAuditingEntity;
import com.sun.istack.NotNull;

@Entity
@Table(name = "cart")
public class CartItems extends AbstractAuditingEntity implements Serializable {	
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartid;

	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "customerId")
	private Customer customer;

	@ManyToOne(targetEntity = Items.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "itemid")
	private Items item;
	
	@OneToMany(mappedBy = "cartItem")
	private List<Order> orders;
	

	@Column(name = "itemname")
	private String itemname;
	
	@Column(name = "price")
	private double price;
	
	  @Min(1) 
	  @Column(name = "quantity",nullable = false)
	  private Long quantity;
	 

	

	public CartItems() {		
	}

	public CartItems(Items item, Customer customer,String itemname,double price,Long quantity) {
		// TODO Auto-generated constructor stub
		this.customer = customer;
		this.item =  item;
		this.itemname=itemname;
		this.price=price;
		this.quantity=quantity;
		
	}

	public CartItems(Items item) {
		
		this.item = item;
	}
	
	public CartItems(Long quantity) {		
		this.quantity = quantity;		
		
	}
	public CartItems(Customer customer) {		
		this.customer = customer;		
		
	}
	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	 public Items getItem() { 
		 return item;
		 }
	 
	  public void setItem(Items item) { 
		  this.item = item; 
		  }

	  public Long getQuantity() {
			return quantity;
		}

		public void setQuantity(Long quantity) {
			this.quantity = quantity;
			
			
		}

	public String getItemname() {
		return itemname;
	}
	

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}
