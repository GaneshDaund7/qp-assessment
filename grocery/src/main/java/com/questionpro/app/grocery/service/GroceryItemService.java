package com.questionpro.app.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.app.grocery.dao.GroceryItemDao;
import com.questionpro.app.grocery.dto.GroceryItemRequest;
import com.questionpro.app.grocery.entity.GroceryItem;

import jakarta.transaction.Transactional;

@Service
public class GroceryItemService {

	@Autowired
	private GroceryItemDao groceryItemDao;
	
	// get all grocery items
	public List<GroceryItem> getAllItems()
	{
		return groceryItemDao.findAll();
	}
	
	//adding grocery item
	public GroceryItem addItem(GroceryItemRequest request)
	{
		GroceryItem item=new GroceryItem();
		item.setId(request.getId());
		item.setName(request.getName());
		item.setPrice(request.getPrice());
		item.setStock(request.getStock());
		return groceryItemDao.save(item);
	}
	
	//update item
	public GroceryItem updateItem(Long id,GroceryItemRequest request)
	{
		GroceryItem item=groceryItemDao.findById(id).orElseThrow(()->new RuntimeException("Such item doesnt exists"));
		item.setName(request.getName());
		item.setPrice(request.getPrice());
		item.setStock(request.getStock());
		return groceryItemDao.save(item);
	}
	
	//delete an item
	public String deleteItem(Long id)
	{
		 groceryItemDao.deleteById(id);
		 return "Item Deleted Successfully!!";

	}
	
	//Update Stock
	@Transactional
	public void updateStock(Long id,int quantity)
	{
		GroceryItem item=groceryItemDao.findById(id).orElseThrow(()->new RuntimeException("Such item doesnt exists"));
        if(item.getStock()<quantity)
        	throw new RuntimeException("Insufficient stock");
        item.setStock(item.getStock()-quantity);
	}
	
	
	
	
	
	
	
	
	
	
}
