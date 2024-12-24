package com.questionpro.app.grocery.dto;

import lombok.Data;

@Data
public class GroceryItemRequest {

	private Long id;
	private String name;
	private double price;
	private int stock;
}
