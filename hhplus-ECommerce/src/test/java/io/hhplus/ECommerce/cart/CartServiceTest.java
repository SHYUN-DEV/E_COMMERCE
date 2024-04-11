package io.hhplus.ECommerce.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import io.hhplus.ECommerce.cart.controller.CartResponse;
import io.hhplus.ECommerce.cart.domain.Cart;
import io.hhplus.ECommerce.cart.domain.CartRepository;
import io.hhplus.ECommerce.cart.domain.CartService;


@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	
	
	@Mock
	private CartRepository cartRepository;

	@InjectMocks
	private CartService cartService; 
	
	@BeforeEach
    void setUp() {
        // Mock 객체 초기화
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	@DisplayName("유저 아이디로 장바구니 정보 가져오기")
	void getCartInfoByUserIdTest() {
	    // 테스트에 필요한 Mock 데이터 설정
		
		 
	    Long userId = 1L;
	    Cart cartItem1 = new Cart(1L, 1L, userId, 2, "N"); // 상품1
	    Cart cartItem2 = new Cart(2L, 2L, userId, 1, "N"); // 상품2
	    List<Cart> cartItems = Arrays.asList(cartItem1, cartItem2);
	        

	    when(cartRepository.findByUserId(userId)).thenReturn(cartItems);

	 
	    List<Cart> result = cartService.getCartItemsByUserId(userId);

	    // 결과 확인
	    assertNotNull(result); // 결과가 null이 아닌지 확인
	    assertEquals(2, result.size()); // 장바구니에 담긴 상품 수 확인

	    // 각 상품의 정보 확인
	    Cart resultCartItem1 = result.get(0);
	    assertEquals(1L, resultCartItem1.getCartId()); 
	    assertEquals(1L, resultCartItem1.getProductId());
	    assertEquals(userId, resultCartItem1.getUserId()); 
	    assertEquals(2, resultCartItem1.getQuantity()); 
	    assertEquals("N", resultCartItem1.getPayStatus()); 

	    Cart resultCartItem2 = result.get(1);
	    assertEquals(2L, resultCartItem2.getCartId()); 
	    assertEquals(2L, resultCartItem2.getProductId()); 
	    assertEquals(userId, resultCartItem2.getUserId()); 
	    assertEquals(1, resultCartItem2.getQuantity()); 
	    assertEquals("N", resultCartItem1.getPayStatus()); 
	}
	
	@Test
	@DisplayName("장바구니에 상품 추가")
	void addProductToCartTest() {
	    // given
	    Long userId = 1L;
	    List<Long> productIds = Arrays.asList(3L, 4L);
	    Cart cartItem1 = new Cart(1L, 1L, userId, 3, "N"); // 상품1
	    Cart cartItem2 = new Cart(2L, 2L, userId, 1, "N"); // 상품2
	    Cart cartItem3 = new Cart(3L, 3L, userId, 1, "N"); // 상품3
	    Cart cartItem4 = new Cart(4L, 4L, userId, 1, "N"); // 상품4
	    
	    List<Cart> cartItems = Arrays.asList(cartItem1, cartItem2, cartItem3, cartItem4);
	    when(cartRepository.findByUserId(userId)).thenReturn(cartItems);

	    // when
	    List<CartResponse> result = cartService.addProductToCart(userId, productIds);

	    // then
	    assertEquals(4, result.size()); // 상품이 추가됐는지 확인
	    // 추가된 상품 정보 확인
	    for (Long productId : productIds) {
	        CartResponse addedCartItem = result.stream()
	                .filter(cartResponse -> productId.equals(cartResponse.getProductId()))
	                .findFirst()
	                .orElse(null);
	        assertNotNull(addedCartItem); // null이 아닌지 확인
	        assertEquals(productId, addedCartItem.getProductId()); // 추가된 상품의 ID 확인
	    }
	}

	
	@Test
	@DisplayName("장바구니에 상품 삭제")
	void cartDelTest() {
	    // given
	    Long userId = 1L;
	    List<Long> productIds = Arrays.asList(4L, 5L); // 삭제할 상품 ID 리스트
	    Cart cartItem1 = new Cart(1L, 1L, userId, 3, "N"); // 상품1
	    Cart cartItem2 = new Cart(2L, 2L, userId, 1, "N"); // 상품2
	    Cart cartItem3 = new Cart(3L, 3L, userId, 1, "N"); // 상품3
	    List<Cart> cartItems = Arrays.asList(cartItem1, cartItem2, cartItem3);
	    when(cartRepository.findByUserId(userId)).thenReturn(cartItems);

	    // when
	    List<CartResponse> result = cartService.delProductToCart(userId, productIds);

	    // then
	    assertEquals(3, result.size()); // 상품이 삭제됐는지 확인
	    for (Long productId : productIds) {
	        // 삭제된 상품 정보 확인
	        CartResponse deletedCartItem = result.stream()
	                .filter(cartResponse -> productId.equals(cartResponse.getProductId()))
	                .findFirst()
	                .orElse(null);
	        assertNull(deletedCartItem); // null인지 확인하여 삭제됐는지 확인
	    }
	}

	
	
	

}
