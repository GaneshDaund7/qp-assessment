package com.questionpro.app.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.app.grocery.dto.GroceryItemRequest;
import com.questionpro.app.grocery.entity.GroceryItem;
import com.questionpro.app.grocery.service.GroceryItemService;

@RestController
@RequestMapping("/api/admin/groceries")
public class AdminController {

	@Autowired
	private GroceryItemService service;
	
	@GetMapping("/allItems")
	public ResponseEntity<?> getAllItems()
	{
		List<GroceryItem> allItems=service.getAllItems();
		return new ResponseEntity<>(allItems,HttpStatus.OK);
	}
	@PostMapping("/addItem")
	public ResponseEntity<?> addItem(@RequestBody GroceryItemRequest request)
	{
		GroceryItem item=service.addItem(request);
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	@PutMapping("/updateItem/{id}")
	public ResponseEntity<?> updateItem(@PathVariable Long id,@RequestBody GroceryItemRequest request)
	{
		GroceryItem item=service.updateItem(id,request);
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable Long id)
	{
		String response=service.deleteItem(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
}
