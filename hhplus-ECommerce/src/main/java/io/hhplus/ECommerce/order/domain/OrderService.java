package io.hhplus.ECommerce.order.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.order.controller.OrderRequest;
import io.hhplus.ECommerce.order.controller.OrderResponse;

@Service
public interface OrderService {

	OrderResponse orderAndPay(Long userId, List<OrderRequest> orderItems);

}
