package com.foodmanagement.foodmanagementsystem.model;

import java.io.Serializable;
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

@Entity
@Table(name = "orders")
public class Order extends AbstractAuditingEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderid;	

	 @Column(name = "quantity",nullable = false)
	  private Long quantity;

	@Column(name = "itemName")
	private String itemName ;
	
	@Column(name = "price")
	private double price;
	
	@Min(1)
	@Column(name = "orderno")
	 private Long orderno;
	
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "customerId")
	private Customer customer;
	
	@ManyToOne(targetEntity = Items.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "itemid")
	private Items item;

	@ManyToOne(targetEntity = CartItems.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "cartid")
	private CartItems cartItem;
	
	
	 public Long getOrderno() {
		return orderno;
	}

	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}

	
	 
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order() {
		
	}
	
	public Order(Customer customer, String itemname, double price,Items item,Long quantity,Long orderno) {
		
		
		this.customer = customer;
		this.itemName = itemname;
		this.price = price;
		this.item=item;
		this.quantity = quantity;
		this.orderno=orderno;
	
		
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


	

	public CartItems getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItems cartItem) {
		this.cartItem = cartItem;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	

	
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
