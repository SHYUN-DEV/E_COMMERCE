package io.hhplus.ECommerce.cart.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.hhplus.ECommerce.cart.controller.CartResponse;
import io.hhplus.ECommerce.cart.domain.CartRepository;


@Repository
public class CartRepositoryImpl implements CartRepository{


	@Override
	public List<CartResponse> cartInfo(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCartInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCartInfo() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	@Override
	public Object findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	
	}

}


	
