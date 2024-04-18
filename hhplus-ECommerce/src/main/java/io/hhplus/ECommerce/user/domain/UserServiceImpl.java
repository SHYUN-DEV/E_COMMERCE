package io.hhplus.ECommerce.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hhplus.ECommerce.user.controller.UserResponse;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponse getUserPoint(Long userId) {
		
		return userRepository.pointInquiry(userId);
	}

	@Override
	public UserResponse chargePoint(Long userId, int chargeAmount) {
		
		
		return userRepository.chargePoint(userId, chargeAmount);
	}

}
