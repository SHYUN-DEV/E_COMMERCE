package io.hhplus.ECommerce.product.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;

@Service
public interface ProductService {

	//상품정보 조회
	ProductResponse getProductInfo(Long productId);
	
	//상위판매상품 5개 가져오기 
	List<OrderDetailProductResponse> getBestProducts();
	
	
	
	ProductResponse getProduct(Long productId1);

	List<ProductResponse> getBestSellingProducts();


	

	



	

}
