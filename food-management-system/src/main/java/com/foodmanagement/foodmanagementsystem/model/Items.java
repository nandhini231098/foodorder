package com.foodmanagement.foodmanagementsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.foodmanagement.foodmanagementsystem.model.entity.AbstractAuditingEntity;

@Entity
@Table(name="itemLists")
public class Items extends AbstractAuditingEntity implements Serializable {

		public Items() {			
		}
		
		public Items(Long itemid, String itemName, double price) {
		
		this.itemid = itemid;
		this.itemName = itemName;
		this.price = price;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid;

	@Column(name = "itemName")
	private String itemName;

	

	@Column(name = "price")
	private double price;
	
	@OneToMany(mappedBy = "item")	
	private List<CartItems> cart;
	

		public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	


		public List<CartItems> getCart() {
		return cart;
	}

	public void setCart(List<CartItems> cart) {
		this.cart = cart;
	}

		public Items(Long itemid) {
		super();
		this.itemid = itemid;
	}

		public Long getItemId() {
			return itemid;
		}

		public void setItemId(Long itemid) {
			this.itemid = itemid;
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
