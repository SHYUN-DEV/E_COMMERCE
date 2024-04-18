package io.hhplus.ECommerce.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

import io.hhplus.ECommerce.exception.InsufficientInventoryException;
import io.hhplus.ECommerce.exception.NotEnoughPointException;
import io.hhplus.ECommerce.order.controller.OrderDetailProductResponse;
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
	void testProcessPayment_Success() {
	      
		Long userId = 1L;
		Long orderId = 1L;
	        
		OrderDetailProductResponse orderDetailProductResponse = new OrderDetailProductResponse();
		orderDetailProductResponse.setInventory(100); 
		orderDetailProductResponse.setQuantity(10);
		orderDetailProductResponse.setTotOrderPrice(50000);;
		 
		List<OrderDetailProductResponse> list = new ArrayList<>();
		list.add(orderDetailProductResponse);
		//주문,주문상세,상품 정보 조회
		when(productRepository.orderProductInfo()).thenReturn(list);
		 
		UserResponse userResponse = new UserResponse();
		userResponse.setPoint(20000); 
		//포인트 조회
		when(userRepository.pointInquiry(userId)).thenReturn(userResponse);
		 
		
		OrderResponse expectedOrderResponse = new OrderResponse();
		expectedOrderResponse.setOrderId(orderId);
		expectedOrderResponse.setUserId(userId);
		expectedOrderResponse.setTotOrderPrice(13000); 
		expectedOrderResponse.setOrderDate("2024-03-31 15:30:00"); 
		expectedOrderResponse.setPayStatus("Y"); 
		 	
		 
		//결제 후 결과
		when(orderRepository.orderInfo(userId, orderId)).thenReturn(new OrderResponse());
		 
		OrderResponse actualOrderResponse = orderService.processPayment(userId, orderId);     
		 
		assertNotNull(actualOrderResponse);
		assertEquals(orderId, actualOrderResponse.getOrderId());
		assertEquals(userId, actualOrderResponse.getUserId());
		assertEquals(13000, actualOrderResponse.getTotOrderPrice());
		assertEquals("2024-03-31 15:30:00", actualOrderResponse.getOrderDate());
		assertEquals("Y", actualOrderResponse.getPayStatus());
		 
	}	
	
		
	@Test
	@DisplayName("주문 수량보다 재고가 적은 경우")
	void testProcessPayment_InsufficientInventoryException() {
	
		Long userId = 1L;
		Long orderId = 1L;
	    OrderDetailProductResponse orderDetailProductResponse = new OrderDetailProductResponse();
	    orderDetailProductResponse.setInventory(5); // 수량보다 재고가 적게 설정
	    orderDetailProductResponse.setQuantity(10); // 주문 수량
	    
	    List<OrderDetailProductResponse> list = new ArrayList<>();
	    list.add(orderDetailProductResponse);
	    
	    when(productRepository.orderProductInfo()).thenReturn(list);


	    assertThrows(InsufficientInventoryException.class, () -> orderService.processPayment(userId, orderId));

	
	}


	 @Test
	 @DisplayName("포인트가 총 상품 가격보다 적은 경우")
	 void testProcessPayment_NotEnoughPointException() {
		
		 Long userId = 1L;
		 Long orderId = 1L;
		
		 OrderDetailProductResponse orderDetailProductResponse = new OrderDetailProductResponse();
		 orderDetailProductResponse.setInventory(100); // 재고가 충분한 수량 설정
		 orderDetailProductResponse.setQuantity(10);
		 orderDetailProductResponse.setTotOrderPrice(10000);;
		 
		
		 List<OrderDetailProductResponse> list = new ArrayList<>();
		 list.add(orderDetailProductResponse);
		 
		 when(productRepository.orderProductInfo()).thenReturn(list);
		 
		 UserResponse userResponse = new UserResponse();
		 userResponse.setPoint(5000); // 주문 총액보다 적은 포인트 설정
		 when(userRepository.pointInquiry(userId)).thenReturn(userResponse);
		 
		
		 assertThrows(NotEnoughPointException.class, () -> orderService.processPayment(userId, orderId));
		 
		
		 
	 }	
	 
	

}



