package io.hhplus.ECommerce.cart.controller;
import java.util.List;

import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
	
	
	private Long cartId;
	
	private Long productId;
	
	private Long userId;
	
	private int quantity;
	
	private List<ProductResponse> products;

}
