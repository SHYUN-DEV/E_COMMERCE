package io.hhplus.ECommerce.order.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	
//	private Long orderId;
//	private Long userId;
//	private int totOrderPrice;
//	private String orderDate;
//	private String orderStatus;
	
	private Long ProductId;
	private int quantity;

}
