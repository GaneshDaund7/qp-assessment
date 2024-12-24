package com.questionpro.app.grocery.dto;

import lombok.Data;

@Data
public class OrderRequest {

	private Long groceryItemId;
	private int quantity;
}
