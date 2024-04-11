package io.hhplus.ECommerce.order.domain;

import java.util.List;

public interface OrderRepository {

	List<OrderDetail> findTop5ByOrderByQuantityDesc();

}
