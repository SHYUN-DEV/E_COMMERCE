package io.hhplus.ECommerce.order.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailProductResponse {
	
	
	private Long orderId;
	private Long userId;
	private int totOrderPrice;
	private String orderDate;
	private String orderStatus;
	
	
	private Long orderDetailId;
	private Long productId;
	private String productName;
	private int quantity;
	private int price; 
	private String orderDetailStatus;
	private String payDate;
	
	
	private int inventory;
	private int salesNumber;
	
	
	

}
