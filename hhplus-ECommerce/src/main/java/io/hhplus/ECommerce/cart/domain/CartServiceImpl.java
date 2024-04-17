package io.hhplus.ECommerce.cart.domain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.cart.controller.CartResponse;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.hhplus.ECommerce.product.domain.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	
	private final ProductRepository productRepository;
	
	@Autowired
	public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
	}
	
	
	//장바구니 상품 정보 조회
	@Transactional
	@Override
	public CartResponse cartInfo(Long userId) {
		
		//유저의 장바구니 정보들을 리스트에 담아서 
		List<CartResponse> cartInfos = cartRepository.cartInfo(userId);
		
		List<Long> productIds = new ArrayList<>();
				
		//상품 아이디만 뽑아서 리스트에 담고 
		for(CartResponse cartResponse : cartInfos){
			productIds.add(cartResponse.getProductId());
		}
				
		// 상품 아이디 리스트를 이용하여 상품 정보 조회
		List<ProductResponse> products = new ArrayList<>();
		for (Long productId : productIds) {
			ProductResponse productResponse = productRepository.getProductInfo(productId);
			products.add(productResponse);
		}
		        
			
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setUserId(userId);
		cartResponse.setProducts(products);
		
		
		
		
		
		return cartResponse;
	}

	//장바구니 상품 추가
	@Override
	public void addCartInfo(Long userId, Long productId, int quantity) {
		

		
		cartRepository.addCartInfo();
		
	}

	//장바구니 상품 삭제 
	@Override
	public void delCartInfo(Long userId, List<Long> productIdsToRemove) {
		
		cartRepository.delCartInfo();
		
	}

	
	
	
	
	
	
	@Override
	public List<Cart> getCartItemsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartResponse> addProductToCart(Long userId, List<Long> productIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartResponse> delProductToCart(Long userId, List<Long> productIds) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
