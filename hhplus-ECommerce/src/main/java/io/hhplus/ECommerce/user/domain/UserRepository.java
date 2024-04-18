package io.hhplus.ECommerce.user.domain;

import java.util.Optional;

import io.hhplus.ECommerce.user.controller.UserResponse;

public interface UserRepository {

	public User findById(Long userId);

	//유저 포인트 조회
	public UserResponse pointInquiry(Long userId);
	
	//유저 포인트 차감
	public void deductPoint(Long userId, int orderPrice);

	//유저 포인트 충전
	public UserResponse chargePoint(Long userId, int chargeAmount);

	
	
	
}
