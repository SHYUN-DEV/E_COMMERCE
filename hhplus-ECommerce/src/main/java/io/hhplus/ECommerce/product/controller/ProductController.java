package io.hhplus.ECommerce.product.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "상품")
@RestController
@RequestMapping("/api")
public class ProductController {
	
//	private final ProductService productService;
//	 
//	 
//	@Autowired
//	public ProductController(ProductService productService) {
//		this.productService = productService;
//	}
//	 
	 
	
	
	@Operation(summary = "상품 조회", description = "상품 정보를 조회 합니다.")
	@GetMapping("/product/inquiry/{productId}")
	public ResponseEntity<ProductResponse> productInquiry(@PathVariable("productId") Long productId) {
		
		ProductResponse productResponse = new ProductResponse();
		
		return ResponseEntity.ok().body(productResponse); 
		
	}

	
	
	@Operation(summary = "인기판매상품 조회", description = "인기판매상품을 조회합니다.")
	@GetMapping("/product/popular")
	public ResponseEntity<ProductResponse> bestProduct() {
		
		
		ProductResponse productResponse = new ProductResponse();
		
		return ResponseEntity.ok().body(productResponse); 
	}
	


}
