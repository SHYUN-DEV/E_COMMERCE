package io.hhplus.ECommerce.order.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "상품 주문")
@RestController
@RequestMapping("/api")
public class OrderController {
	
//	private final OrderService orderService;
//	 
//	 
//	@Autowired
//	public OrderController(OrderService orderService) {
//		this.orderService = orderService;
//	}
	 

	
	
	@Operation(summary = "주문/결제", description = "주문과 결제를 합니다.")
	@PostMapping("/payment/{userId}")
	public ResponseEntity<OrderResponse> payment(@PathVariable("userId") Long userId,
                                                   @RequestBody Long orderId) {
		
		OrderResponse orderResponse = new OrderResponse();
		
		return ResponseEntity.ok().body(orderResponse); 
			
	}
	
	


}
