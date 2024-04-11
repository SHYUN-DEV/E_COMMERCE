package io.hhplus.ECommerce.cart.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.cart.controller.CartResponse;

@Service
public interface CartService {

	List<Cart> getCartItemsByUserId(Long userId);

	List<CartResponse> addProductToCart(Long userId, List<Long> productIds);

	List<CartResponse> delProductToCart(Long userId, List<Long> productIds);

}
