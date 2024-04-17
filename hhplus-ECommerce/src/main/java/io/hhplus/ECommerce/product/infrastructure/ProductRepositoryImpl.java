package io.hhplus.ECommerce.product.infrastructure;

import java.util.List;

import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.hhplus.ECommerce.product.domain.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository{

	@Override
	public Object findById(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponse getProductInfo(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailProductResponse> orderProductInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deductQuantity(Long productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
