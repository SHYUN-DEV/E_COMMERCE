package io.hhplus.ECommerce.order.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.cart.domain.CartRepository;
import io.hhplus.ECommerce.order.controller.OrderDetailResponse;
import io.hhplus.ECommerce.order.controller.OrderProductResponse;
import io.hhplus.ECommerce.order.controller.OrderRequest;
import io.hhplus.ECommerce.order.controller.OrderResponse;
import io.hhplus.ECommerce.product.domain.ProductRepository;
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final UserRepository userRepository;
	
	private final CartRepository cartRepository;
	
	private final ProductRepository productRepository;
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(CartRepository cartRepository,
			               ProductRepository productRepository, 
			               UserRepository userRepository,
			               OrderRepository orderRepository) {
		
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
	}

	
		
	@Override
	public OrderResponse processPayment(Long userId, Long orderId) {
		
		//주문 상품 정보 조회(주문, 주문상세, 상품 테이블 조인)
		List<OrderProductResponse> orderProductResponse = productRepository.orderProductInfo();
				
				
		//상품 재고 차감(위 코드에서 가져온  productIdQuantity(상품아이디와구매수량)로 상품들 재고 차감)
		for (OrderProductResponse productIdQuantity : orderProductResponse) {
			Long productId = productIdQuantity.getProductId();
			int quantity = productIdQuantity.getQuantity();
			// 상품 재고 차감 업데이트 
			productRepository.deductQuantity(productId, quantity);
		}
		
		
		//재고차감시 에러발생한 상품 예외 처리(싱테변경 혹은 해당 아이디 주문 상세 삭제)...
			
		//현재 유저 포인트 조회 
		UserResponse userResponse= userRepository.pointInquiry(userId);
		
		//포인트 부족시 예외처리 ......
			
		
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
