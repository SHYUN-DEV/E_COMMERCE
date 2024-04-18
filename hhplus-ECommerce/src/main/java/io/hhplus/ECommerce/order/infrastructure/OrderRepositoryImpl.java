package io.hhplus.ECommerce.order.infrastructure;

import java.util.List;

import io.hhplus.ECommerce.order.controller.OrderResponse;
import io.hhplus.ECommerce.order.domain.OrderDetail;
import io.hhplus.ECommerce.order.domain.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

	@Override
	public List<OrderDetail> findTop5ByOrderByQuantityDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Long userId, Long orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderResponse orderInfo(Long userId, Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
