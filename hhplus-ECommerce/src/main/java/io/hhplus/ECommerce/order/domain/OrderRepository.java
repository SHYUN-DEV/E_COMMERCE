package io.hhplus.ECommerce.order.domain;

import java.util.List;

import io.hhplus.ECommerce.order.controller.OrderResponse;

public interface OrderRepository {

	List<OrderDetail> findTop5ByOrderByQuantityDesc();
	
	//주문테이블 결제시간,결제상태 업데이트
	void updateOrder(Long userId, Long orderId);

	//주문테이블 정보 가져오기
	OrderResponse orderInfo(Long userId, Long orderId);

}
