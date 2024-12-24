package com.questionpro.app.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.app.grocery.dto.OrderRequest;
import com.questionpro.app.grocery.entity.GroceryItem;
import com.questionpro.app.grocery.service.GroceryItemService;

@RestController
@RequestMapping("/api/user/groceries")
public class UserController {

	@Autowired
	private GroceryItemService service;
	
	@GetMapping("/allAvailableItems")
	public ResponseEntity<?> getAllAvailableItems()
	{
		List<GroceryItem> allItems=service.getAllItems();
		return new ResponseEntity<>(allItems,HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> orderItem(@RequestBody List<OrderRequest> orders)
	{
		for(OrderRequest order  :orders)
		{
			service.updateStock(order.getGroceryItemId(),order.getQuantity());
		}
		return new ResponseEntity<>("Oder has successfully placed!!",HttpStatus.OK);
	}
}
