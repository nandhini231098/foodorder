package com.foodmanagement.foodmanagementsystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodmanagement.foodmanagementsystem.model.Items;

@Repository
public interface ItemsDao extends CrudRepository<Items, Long> {
	List<Items> findByItemName(String itemName);

	List<Items> findByItemid(Long itemid);
	
	//Items findByItemid(Long itemid);

}
