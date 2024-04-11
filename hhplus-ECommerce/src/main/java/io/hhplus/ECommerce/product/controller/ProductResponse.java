package io.hhplus.ECommerce.product.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	
	private Long productId;
	
	private String productName;
	
	private int productPrice;
	
	private int inventory;
	
	private int salesNumber;

}
