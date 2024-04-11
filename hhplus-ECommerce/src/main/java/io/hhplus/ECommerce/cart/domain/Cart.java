package io.hhplus.ECommerce.cart.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cartId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "pay_status")
	private String payStatus;	
	
	
}
