package io.hhplus.ECommerce.product.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
import io.hhplus.ECommerce.product.domain.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "상품")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	private final ProductService productService;
	 
	 
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	 
	 
	
	
	@Operation(summary = "상품 조회", description = "상품 정보를 조회 합니다.")
	@GetMapping("/product/inquiry/{productId}")
	public ResponseEntity<List<ProductResponse>> productInquiry(@RequestParam("productIds") List<Long> productIds) {
		
		List<ProductResponse> productInfo = new ArrayList<>();
		
		for(Long productId : productIds) {
			ProductResponse productResponse = productService.getProductInfo(productId);
			productInfo.add(productResponse);
		}
		
		
		return ResponseEntity.ok().body(productInfo); 
		
	}

	
	
	@Operation(summary = "인기판매상품 조회", description = "인기판매상품을 조회합니다.")
	@GetMapping("/product/popular")
	public ResponseEntity<List<OrderDetailProductResponse>> bestProduct() {
		
		
		ProductResponse productResponse = new ProductResponse();
		
		List<OrderDetailProductResponse> bestProductList = productService.getBestProducts();
		
		return ResponseEntity.ok().body(bestProductList); 
	}
	


}
