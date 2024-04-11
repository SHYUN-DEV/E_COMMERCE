package io.hhplus.ECommerce.order.controller;

import java.util.List;

import io.hhplus.ECommerce.product.controller.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	
	private Long orderId;
	private Long userId;
	private int totOrderPrice;
	private String orderDate;
	private String payStatus;
	
	private List<OrderDetailResponse> orderItems;
	

}
