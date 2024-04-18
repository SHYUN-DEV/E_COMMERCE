package io.hhplus.ECommerce.order.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import io.hhplus.ECommerce.exception.InsufficientInventoryException;
import io.hhplus.ECommerce.exception.NotEnoughPointException;
import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.order.controller.OrderRequest;
import io.hhplus.ECommerce.order.controller.OrderResponse;
import io.hhplus.ECommerce.product.domain.ProductRepository;
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final UserRepository userRepository;
	
	private final ProductRepository productRepository;
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(ProductRepository productRepository, 
			               UserRepository userRepository,
			               OrderRepository orderRepository) {
		
	
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
	}

	
	@Transactional(isolation = Isolation.READ_COMMITTED)	
	@Override
	public OrderResponse processPayment(Long userId, Long orderId) {
		
		//주문 상품 정보 조회(주문, 주문상세, 상품 테이블 조인)
		List<OrderDetailProductResponse> orderProductResponse = productRepository.orderProductInfo();
				
				
		//상품 재고 차감(위 코드에서 가져온  productIdQuantity(상품아이디와구매수량)로 상품들 재고 차감)
		for (OrderDetailProductResponse productIdQuantity : orderProductResponse) {
				
			    int inventory = productIdQuantity.getInventory();
				Long productId = productIdQuantity.getProductId();
				int quantity = productIdQuantity.getQuantity();
			
			if(inventory >= quantity) {
				//차감한 수량 업데이트
				productRepository.deductQuantity(productId,(inventory - quantity));
			}else {
				// 재고가 부족한 경우 처리
	            throw new InsufficientInventoryException("상품 재고가 부족합니다.");
			}
			
		}
		
			
		//현재 유저 포인트 조회 
		UserResponse userResponse= userRepository.pointInquiry(userId);
		
			
		if(orderProductResponse.get(0).getTotOrderPrice() > userResponse.getPoint()) {
			// 포인트가 부족할경우 처리 
            throw new NotEnoughPointException("결제할 포인트가 부족합니다.");
		}
		
		//포인트 차감 업데이트//
		int orderPrice = orderProductResponse.get(0).getTotOrderPrice();
		userRepository.deductPoint(userId, orderPrice);
			
			
		//주문상세/주문에 결제상태 결제날짜	업데이트    
		//orderRepository.updateOrderDetil(UserId, 주문상세아이디);
		orderRepository.updateOrder(userId, orderProductResponse.get(0).getOrderId());
		
			
		//최신화 된 주문테이블 정보 가져오기
		OrderResponse orderResponse = orderRepository.orderInfo(userId, orderId);
		
		
		return orderResponse;
	}


	
	
	

	@Override
	public OrderResponse orderAndPay(Long userId, List<OrderRequest> orderItems) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
