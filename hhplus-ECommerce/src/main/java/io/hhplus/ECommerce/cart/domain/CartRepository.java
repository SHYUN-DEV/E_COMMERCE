package io.hhplus.ECommerce.cart.domain;

import java.util.List;

import io.hhplus.ECommerce.cart.controller.CartResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;

public interface CartRepository {

	//장바구니 조회
	public List<CartResponse> cartInfo(Long userId);
	
	//장바구니 정보 추가
	public void addCartInfo();
	
	//장바구니 정보 삭제
	public void delCartInfo();
	

	
	
	public Object findByUserId(Long userId);



}
