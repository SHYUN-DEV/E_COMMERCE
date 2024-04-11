package io.hhplus.ECommerce.order.controller;

import java.util.List;

import io.hhplus.ECommerce.product.controller.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailResponse {
	
	private Long productId;
	private String productName;
	private int quantity;
	private int price;

}
