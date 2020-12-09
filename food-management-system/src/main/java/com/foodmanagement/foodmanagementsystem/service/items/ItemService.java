package com.foodmanagement.foodmanagementsystem.service.items;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.model.Items;

@Service
public interface ItemService {
	 public List<Items> getAllItems();	
	 
	 Page <Items> findPaginated(int pageNo, int pageSize);
	 
	public List<Items> getitembyId(Long itemid);
	
	 Items getitemsbyid(Long itemid);
	
	public void saveOrUpdate(Items user);
	
	 public void deleteitem(Long itemid);
	
	
}
