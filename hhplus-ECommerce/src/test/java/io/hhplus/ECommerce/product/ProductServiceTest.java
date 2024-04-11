package io.hhplus.ECommerce.product;

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
import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.UserRepository;
import io.hhplus.ECommerce.user.domain.UserService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private ProductService productService; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}	
	
	 @Test
	 @DisplayName("상품 조회")
	 void testProductInquiry() {
		 
		 Long productId1 = 1L;
		 Long productId2 = 2L;
		 
		 Product product1 = new Product(productId1, "상품1", 5000, 10, 50);
		 Product product2 = new Product(productId2, "상품2", 8000, 5, 30);
		 
		 when(productRepository.findById(productId1)).thenReturn(product1);
		 when(productRepository.findById(productId2)).thenReturn(product2);

		
		 ProductResponse result1 = productService.getProduct(productId1);
		 ProductResponse result2 = productService.getProduct(productId2);

		
		 assertEquals(productId1, result1.getProductId());
		 assertEquals("상품1", result1.getProductName());
		 assertEquals(5000, result1.getProductPrice());
		 assertEquals(10, result1.getInventory());
	        
		 assertEquals(productId2, result2.getProductId());
		 assertEquals("상품2", result2.getProductName());
		 assertEquals(8000, result2.getProductPrice());
		 assertEquals(5, result2.getInventory());
	 }
	
	 @Test
	 @DisplayName("인기 판매 상품 조회")
	 void testBestInquiry() {
	
		 Long userId = 1L;
		 
		 List<OrderDetail> orderDetails = Arrays.asList(
				 new OrderDetail(1L, 100L, userId, 1L, "상품1", 2, 0), 
				 new OrderDetail(2L, 101L, userId, 2L, "상품2", 3, 0), 
				 new OrderDetail(3L, 100L, userId, 3L, "상품3", 1, 0), 
				 new OrderDetail(4L, 102L, userId, 4L, "상품4", 4, 0), 
				 new OrderDetail(5L, 101L, userId, 5L, "상품5", 2, 0)  
				 );
		 when(orderRepository.findTop5ByOrderByQuantityDesc()).thenReturn(orderDetails);

	
		 List<ProductResponse> result = productService.getBestSellingProducts();

		
		 assertEquals(5, result.size());
	     assertEquals(4L, result.get(0).getProductId()); 
		
	    
	 }



}
