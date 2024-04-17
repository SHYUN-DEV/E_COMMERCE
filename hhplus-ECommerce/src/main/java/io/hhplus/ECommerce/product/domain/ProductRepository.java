package io.hhplus.ECommerce.product.domain;

import java.util.List;

import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;

public interface ProductRepository {

	Object findById(long productId);

	ProductResponse getProductInfo(Long productId);

	
	//주무상세저보조회(주문, 주문상세, 상품 테이블)
	List<OrderDetailProductResponse> orderProductInfo();

	//상품 재고 차감 업데이트
	void deductQuantity(Long productId, int quantity);



	
	


	

}
