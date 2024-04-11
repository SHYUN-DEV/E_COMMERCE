package io.hhplus.ECommerce.product.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.product.controller.ProductResponse;

@Service
public interface ProductService {

	ProductResponse getProduct(Long productId1);

	List<ProductResponse> getBestSellingProducts();

	



	

}
