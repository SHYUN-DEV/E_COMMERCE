package io.hhplus.ECommerce.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import io.hhplus.ECommerce.order.controller.OrderRequest;
import io.hhplus.ECommerce.order.controller.OrderResponse;
import io.hhplus.ECommerce.order.domain.OrderRepository;
import io.hhplus.ECommerce.order.domain.OrderService;
import io.hhplus.ECommerce.order.domain.Order;
import io.hhplus.ECommerce.order.domain.OrderDetail;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.hhplus.ECommerce.product.domain.Product;
import io.hhplus.ECommerce.product.domain.ProductRepository;
import io.hhplus.ECommerce.product.domain.ProductService;
import io.hhplus.ECommerce.user.controller.UserRequest;
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.User;
import io.hhplus.ECommerce.user.domain.UserRepository;
import io.hhplus.ECommerce.user.domain.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}	
	
	@DisplayName("포인트 충전")
	@Test
	void testPointCharge() {
	    // given
	    Long userId = 1L;
	    int initialPoint = 10000; //초기 포인트
	    int chargeAmount = 5000; // 충전할 금액

	    // 사용자 정보
	    User user = new User(userId, "사용자1", initialPoint);
	    when(userRepository.findById(userId)).thenReturn(user);

	    // when
	    UserResponse result = userService.chargePoint(userId, chargeAmount);

	    // then
	    int expectedPoint = initialPoint + chargeAmount; // 예상 포인트 잔액
	    assertEquals(expectedPoint, result.getPoint());
	    assertEquals(userId, result.getUserId());
	}
	
	  @DisplayName("포인트 조회")
	    @Test
	    void testPointInquiry() {
	        // given
	        Long userId = 1L;
	        int expectedPoint = 10000; // 예상 포인트 잔액

	        // 사용자 정보 
	        User user = new User(userId, "사용자1", expectedPoint);
	        when(userRepository.findById(userId)).thenReturn(user);

	        // when
	        int result = userService.getUserPoint(userId).getPoint();

	        // then
	        assertEquals(expectedPoint, result);
	    }



}
