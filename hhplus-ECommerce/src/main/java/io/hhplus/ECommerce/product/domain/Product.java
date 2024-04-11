package io.hhplus.ECommerce.product.domain;


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
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "procduct_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private int productPrice;
	
	@Column(name = "inventory")
	private int inventory;
	
	@Column(name = "sales_number")
	private int salesNumber;
	

}
