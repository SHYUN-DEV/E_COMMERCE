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
		
	
//		//주문 상품 정보 조회(주문, 주문상세, 상품 테이블 조인)
//		List<OrderProductResponse> orderProductResponse = productService.orderProductInfo();
//		
//		
//		
//		//상품 재고 차감(위 코드에서 가져온  productIdQuantity(상품아이디와구매수량)로 상품들 재고 차감)
//		
//		
//		for (OrderDetailResponse orderDetailResponse : orderProductResponse) {
//		    Long productId = orderDetailResponse.getProductId();
//		    int quantity = orderDetailResponse.getQuantity();
//		    // 상품 재고 차감 업데이트 
//		    productService.deductQuantity(productId, quantity);
//		}
//		
//		//현재 유저 포인트 조회 
//		UserResponse userResponse= userService.pointInquiry(userId);
//		
//		//포인트 차감 업데이트//
//		int orderPrice = orderProductResponse.get(0).getTotOrderPrice();
//		userService.deductPoint(userId, orderPrice);
//		
//		
//		//주문상세/주문에 결제상태 결제날짜	업데이트    
//		orderService.updateOrderDateStatus;
//		
//		//최신화 된 주문테이블 정보 가져오기
//		OrderResponse orderResponse = orderService.orderInfo(userId, orderId);
	
		
		
		
		//오더 테이블 반환 	 오더테이블  가져오기
		return ResponseEntity.ok().body(orderResponse); 
			
	}
	
	


}
