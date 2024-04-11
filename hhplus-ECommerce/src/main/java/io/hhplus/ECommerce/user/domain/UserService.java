package io.hhplus.ECommerce.user.domain;

import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.user.controller.UserResponse;

@Service
public interface UserService {

	UserResponse getUserPoint(Long userId);

	UserResponse chargePoint(Long userId, int chargeAmount);

}
