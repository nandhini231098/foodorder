package com.foodmanagement.foodmanagementsystem.service.items;

import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foodmanagement.foodmanagementsystem.dao.ItemsDao;
import com.foodmanagement.foodmanagementsystem.dao.PagingDao;
import com.foodmanagement.foodmanagementsystem.model.Items;
@Service
@Transactional
public class ItemImpl  implements ItemService{
	org.jboss.logging.Logger logger=LoggerFactory.logger(ItemImpl.class);
	
@Autowired
 ItemsDao  dao;

@Autowired
PagingDao  repos;


@Override
public List<Items> getAllItems() {	
	return(List<Items>) dao.findAll();
}

@Override
public Page<Items> findPaginated(int pageNo, int pageSize) {
	 Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
	 return this.repos.findAll(pageable);
}

@Override
public void saveOrUpdate(Items user) {
	dao.save(user);
	
}

	@Override
	public List<Items> getitembyId(Long itemid) {
		// TODO Auto-generated method stub
		List<Items> items=dao.findByItemid(itemid);
		return items;
	}

	@Override
	public Items getitemsbyid(Long itemid) {		
		return dao.findById(itemid).get();
	}

	@Override
	public void deleteitem(Long itemid) {
	 dao.deleteById(itemid);
		
	}

	












/*@Override
public Items getitemsById(Long itemid) {
	return dao.findById(itemid).get();
}*/



	
}
