package io.hhplus.ECommerce.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hhplus.ECommerce.order.domain.OrderService;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.hhplus.ECommerce.product.domain.ProductService;
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "상품 주문")
@RestController
@RequestMapping("/api")
public class OrderController {
	
	private final OrderService orderService;
	
	private final ProductService productService;
	 
	private final UserService userService;
	 
	@Autowired
	public OrderController(OrderService orderService, ProductService productService, UserService userService) {
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
	}
	 

	
	
	@Operation(summary = "주문/결제", description = "주문과 결제를 합니다.")
	@PostMapping("/payment/{userId}")
	public ResponseEntity<OrderResponse> payment(@PathVariable("userId") Long userId,
                                                   @RequestBody Long orderId) {
		
		 OrderResponse orderResponse = orderService.processPayment(userId, orderId);
		

		
		return ResponseEntity.ok().body(orderResponse); 
			
	}
	
	


}
