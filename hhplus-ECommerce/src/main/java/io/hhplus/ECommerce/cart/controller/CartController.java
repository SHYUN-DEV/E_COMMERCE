package io.hhplus.ECommerce.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hhplus.ECommerce.cart.domain.CartService;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "장바구니")
@RestController
@RequestMapping("/api")
public class CartController {
	
	private final CartService cartService;

	 
	 
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
		
	}

	
	@Operation(summary = "장바구니 조회", description = "장바구니(카트 안 상품정보) 조회를 합니다.")
	@ApiResponse(responseCode = "200", description = "장바구니 상품 정보를 조회를 성공하였습니다.")
	@ApiResponse(responseCode = "404", description = "장바구니에 상품이 없습니다.")
	@ApiResponse(responseCode = "500", description = "서버에서 오류가 발생했습니다. 나중에 다시 시도 해주세요")
	@GetMapping("/cart/{userId}")
	public ResponseEntity<CartResponse>  cartInquiry(@PathVariable("userId") Long userId) {
		
		
		//유저의 장바구니 정보들을 리스트에 담아서 
		CartResponse cartResponse = cartService.cartInfo(userId);
		

		
		return ResponseEntity.ok().body(cartResponse); 
	};
	
	
	
	
	@Operation(summary = "장바구니 상품 추가", description = "장바구니애 상품을 추가합니다.")
	@ApiResponse(responseCode = "404", description = "아이디의 해당하는 사용자를 찾을수가 없습니다.")
	@ApiResponse(responseCode = "500", description = "서버에서 오류가 발생했습니다. 나중에 다시 시도 해주세요")
	@PostMapping("/cart/add/{userId}")
	public ResponseEntity<CartResponse> cartAdd(@PathVariable("userId") Long userId,
												@RequestBody List<CartRequest> productIdQuantity ) {
		
		// 상품 추가 반영//
		
		for (CartRequest request : productIdQuantity) {
	        
			Long productId = request.getProductId();
	        int quantity = request.getQuantity();
	        
	        cartService.addCartInfo(userId, productId, quantity);
	    }
		
		
		//최신화된 장바구니 정보 가져오기//
		
		CartResponse cartResponse = cartService.cartInfo(userId);

    
		
		
		return ResponseEntity.ok().body(cartResponse); 
	};
	
	
	@Operation(summary = "장바구니 상품 삭제", description = "장바구니애 상품 정보를 삭제합니다.")
	@ApiResponse(responseCode = "404", description = "아이디의 해당하는 사용자를 찾을수가 없습니다.")
	@ApiResponse(responseCode = "500", description = "서버에서 오류가 발생했습니다. 나중에 다시 시도 해주세요")
	@PostMapping("/cart/delete/{userId}")
	public ResponseEntity<CartResponse> cartDel(@PathVariable("userId") Long userId,
            					   				@RequestBody List<Long> productIds) {
		//상품삭제//
	
		//장바구니 상품정보
		CartResponse cartInfo = cartService.cartInfo(userId);
	    
	    // 삭제할 상품 아이디 목록
	    List<Long> productIdsToRemove = new ArrayList<>();

	    // cartInfos 리스트를 순회하면서 상품 아이디가 productIds에 포함되어 있는지 확인
	    for (ProductResponse productResponse : cartInfo.getProducts()) {
	        // 만약 상품 아이디가 productIds에 포함되어 있다면 삭제 대상 리스트에 추가
	        if (productIds.contains(productResponse.getProductId())) {
	            productIdsToRemove.add(productResponse.getProductId());
	        }
	    }
	    
	    //삭제 반영
	    cartService.delCartInfo(userId, productIdsToRemove);


	    // 삭제 후 최신화된 장바구니 정보 가져오기  //
	    
	    CartResponse cartResponse = cartService.cartInfo(userId);
	   
		
		
		
		
		return ResponseEntity.ok().body(cartResponse); 
	};
		
	

}
