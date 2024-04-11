package io.hhplus.ECommerce.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	private Long userId;
	private String userName;
	private int point;

}
