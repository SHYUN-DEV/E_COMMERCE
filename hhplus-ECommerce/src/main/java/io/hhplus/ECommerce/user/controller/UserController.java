package io.hhplus.ECommerce.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.hhplus.ECommerce.user.domain.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "유저 포인트")
@RestController
@RequestMapping("/api")
public class UserController {
	
//	private final UserService userService;
//	 
//	 
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
	 
	 
	 
	@Operation(summary = "포인트 충전", description = "유저의 포인트를 충전합니다.")
	@PostMapping("/point/charge/{userId}")
	public  ResponseEntity<UserResponse> pointCharge(@PathVariable("userId") Long userId,
								  @RequestBody int point) {
		
		UserResponse userResponse = new UserResponse();
		
		return ResponseEntity.ok().body(userResponse); 
	}
	
	
	@Operation(summary = "포인트 조회", description = "유저의 포인트를 조회합니다.")
	@GetMapping("/point/inquiry/{userId}")
	public ResponseEntity<UserResponse> pointInquiry(@PathVariable("userId") Long userId) {
		
		
		UserResponse userResponse = new UserResponse();
		
		return ResponseEntity.ok().body(userResponse); 
	}
	


}
