package io.hhplus.ECommerce.user.domain;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.user.controller.UserResponse;

@Service
public interface UserService {

	//포인트 조회
	UserResponse getUserPoint(Long userId);

	//포인트 충전
	UserResponse chargePoint(Long userId, int chargeAmount);

}
