package io.hhplus.ECommerce.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "장바구니")
@RestController
@RequestMapping("/api")
public class CartController {
	
//	private final CartService cartService;
//	
//	private final ProductService productService;
//	 
//	 
//	@Autowired
//	public CartController(CartService cartService, ProductService productService) {
//		this.cartService = cartService;
//		this.productService = productService;
//	}

	
	@Operation(summary = "장바구니 조회", description = "장바구니(카트 안 상품정보) 조회를 합니다.")
	//@ApiResponse(responseCode = "200", description = "OK !!")
	@ApiResponse(responseCode = "200", description = "장바구니 상품 정보를 조회를 성공하였습니다.")
	@ApiResponse(responseCode = "404", description = "장바구니에 상품이 없습니다.")
	@GetMapping("/cart/{userId}")
	public ResponseEntity<CartResponse>  cartInquiry(@PathVariable("userId") Long userId) {
		
//		
//		//유저의 장바구니 정보(여러개의 로우) 리스트에 담아서 
//		
//		List<CartResponse> cartInfos = cartService.cartInfo(userId);
//		
//		List<Long> productIds = new ArrayList<>();
//		
//		//상품 아이디만 뽑아서 리스트에 담고 
//		for(CartResponse cartResponse : cartInfos){
//			productIds.add(cartResponse.getProductId());
//		}
//		
//	    // 상품 아이디 리스트를 이용하여 상품 정보 조회
//        List<ProductResponse> products = new ArrayList<>();
//        for (Long productId : productIds) {
//        	ProductResponse productResponse = productService.getProductInfo(productId);
//            products.add(productResponse);
//        }
//        
		List<ProductResponse> products = new ArrayList<>();
		
		CartResponse cartResponse = new CartResponse();
		
		 cartResponse.setUserId(userId);
	     cartResponse.setCartId(1L); 
	     cartResponse.setProducts(products);
		
		
		
		
		return ResponseEntity.ok().body(cartResponse); 
	};
	
	
	
	
	@Operation(summary = "장바구니 상품 추가", description = "장바구니애 상품을 추가합니다.")
	@PostMapping("/cart/add/{userId}")
	public ResponseEntity<CartResponse> cartAdd(@PathVariable("userId") Long userId,
												@RequestBody List<Long> productIds) {

//		//장바구니 있는지 없는지
//		
//		// 상품 정보 생성
//        List<ProductResponse> products = new ArrayList<>();
//        for (Long productId : productIds) {
//            // 각 상품에 대한 정보를 조회하여 ProductInfo 객체 생성 및 리스트에 추가
//        	ProductResponse productResponse = productService.getProductInfo(productId);
//            products.add(productResponse);
//        }
//
//        // CartResponse 객체 생성 및 필드 설정
//        CartResponse cartResponse = new CartResponse();
//        cartResponse.setUserId(userId);
//        cartResponse.setCartId(cartId); 
//        cartResponse.setProducts(products);
//        
        
        List<ProductResponse> products = new ArrayList<>();
		
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setUserId(userId);
	    cartResponse.setCartId(1L); 
	    cartResponse.setProducts(products);
		
				
		
		
		
		return ResponseEntity.ok().body(cartResponse); 
	};
	
	
	@Operation(summary = "장바구니 상품 삭제", description = "장바구니애 상품 정보를 삭제합니다.")
	@PostMapping("/cart/delete/{userId}")
	public ResponseEntity<CartResponse> cartDel(@PathVariable("userId") Long userId,
            					   				@RequestBody List<Long> productId) {
		
		List<ProductResponse> products = new ArrayList<>();
		
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setUserId(userId);
	    cartResponse.setCartId(1L); 
	    cartResponse.setProducts(products);
		
		
		
		
		return ResponseEntity.ok().body(cartResponse); 
	};
		
	

}
