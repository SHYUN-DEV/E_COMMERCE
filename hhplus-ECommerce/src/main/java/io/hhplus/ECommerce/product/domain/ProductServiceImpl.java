package io.hhplus.ECommerce.product.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	
	//상품정보조회
	@Override
	public List<ProductResponse> getProductInfo(List<Long> productIds) {
		
		List<ProductResponse> productInfo = new ArrayList<>();
		
		for(Long productId : productIds) {
			ProductResponse productResponse = productRepository.getProductInfo(productId);
			productInfo.add(productResponse);
		}
		
		
		return productInfo;
	}
	
	
	//상위판매상품 조회
	@Override
	public List<OrderDetailProductResponse> getBestProducts() {
		
		List<OrderDetailProductResponse> bestProducts = productRepository.getBestProducts();
		
		return bestProducts;
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public ProductResponse getProduct(Long productId1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductResponse> getBestSellingProducts() {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
