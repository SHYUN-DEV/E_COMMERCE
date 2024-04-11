package io.hhplus.ECommerce.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import io.hhplus.ECommerce.order.controller.OrderDetailResponse;
import io.hhplus.ECommerce.order.controller.OrderRequest;
import io.hhplus.ECommerce.order.controller.OrderResponse;
import io.hhplus.ECommerce.order.domain.OrderRepository;
import io.hhplus.ECommerce.order.domain.OrderService;
import io.hhplus.ECommerce.order.domain.Order;
import io.hhplus.ECommerce.product.controller.ProductResponse;
import io.hhplus.ECommerce.product.domain.Product;
import io.hhplus.ECommerce.product.domain.ProductRepository;
import io.hhplus.ECommerce.product.domain.ProductService;
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.UserRepository;
import io.hhplus.ECommerce.user.domain.UserService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderService orderService; 
	
	@InjectMocks
	private ProductService productService; 
	
	@InjectMocks
	private UserService userService; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	@DisplayName("주문/결제")
	void testOrderPayWithMultipleProducts() {
	    
	    Long userId = 1L;
	    Long orderId = 1L;
	    List<OrderRequest> orderItems = Arrays.asList(
	            new OrderRequest(100L, 2),
	            new OrderRequest(101L, 1) 
	    );

	    Product product1 = new Product(100L, "상품1", 5000, 10, 50);
	    Product product2 = new Product(101L, "상품2", 8000, 5, 30);

	    // 상품 정보 조회 
	    when(productRepository.findById(100L)).thenReturn(product1);
	    when(productRepository.findById(101L)).thenReturn(product2);  

	    // 사용자 포인트 조회 
	    UserResponse userResponse = new UserResponse(userId, "사용자1", 20000); // 사용자 포인트 정보
	    when(userService.getUserPoint(userId)).thenReturn(userResponse);

	    
	    // 주문 상세 정보 설정
	    List<OrderDetailResponse> orderedItems = Arrays.asList(
	            new OrderDetailResponse(100L, "상품1", 2, 5000),
	            new OrderDetailResponse(101L, "상품2", 1, 8000)
	    );
	 
	    // 반환되는 주문 정보
	    OrderResponse orderResponse = new OrderResponse(orderId, userId, 13000, "2024-03-31T15:30:00", "Y", orderedItems);
	    when(orderService.orderAndPay(userId, orderItems)).thenReturn(orderResponse);

	    
	    OrderResponse result = orderService.orderAndPay(userId, orderItems);

	   
	    assertNotNull(result); // 주문 결과가 null이 아닌지 확인
	    assertEquals(orderId, result.getOrderId()); // 주문 결과의 주문 아이디가 일치하는지 확인
	    assertEquals(userId, result.getUserId()); // 주문 결과의 사용자 ID가 일치하는지 확인
	    assertEquals(13000, result.getTotOrderPrice()); // 주문 결과의 총 주문 가격이 일치하는지 확인
	    assertEquals("2024-03-31T15:30:00", result.getOrderDate()); // 주문 결과의 주문 날짜가 일치하는지 확인
	    assertEquals("Y", result.getPayStatus()); // 주문 결과의 주문 상태가 일치하는지 확인
	    


		
		}

	    
	    
	}




