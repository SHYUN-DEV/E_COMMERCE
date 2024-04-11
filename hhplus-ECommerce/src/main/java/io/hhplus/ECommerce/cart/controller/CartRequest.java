package io.hhplus.ECommerce.cart.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
	
	private Long cartId;
	
	private Long productId;
	
	private Long userId;
	
	private int quantity;
	
	private String payStatus;

}
