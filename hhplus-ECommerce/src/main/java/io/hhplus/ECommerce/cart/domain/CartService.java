package io.hhplus.ECommerce.cart.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.cart.controller.CartResponse;


public interface CartService {

	
	//장바구니 정보 조회
	CartResponse cartInfo(Long userId);
	
	//장바구니 상품추가
	void addCartInfo(Long userId, Long productId, int quantity);
	
	//장바구니 상품삭제
	void delCartInfo(Long userId, List<Long> productIdsToRemove);
	
	
	
	List<Cart> getCartItemsByUserId(Long userId);

	List<CartResponse> addProductToCart(Long userId, List<Long> productIds);

	List<CartResponse> delProductToCart(Long userId, List<Long> productIds);


}
