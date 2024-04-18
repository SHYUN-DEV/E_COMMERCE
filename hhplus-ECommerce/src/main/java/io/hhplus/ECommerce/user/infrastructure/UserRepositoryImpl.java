package io.hhplus.ECommerce.user.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.hhplus.ECommerce.user.controller.UserResponse;
import io.hhplus.ECommerce.user.domain.User;
import io.hhplus.ECommerce.user.domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	//포인트 조회
	@Override
	public UserResponse pointInquiry(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	//포인트차갑
	@Override
	public void deductPoint(Long userId, int orderPrice) {
		// TODO Auto-generated method stub
		
	}


	//포인트충전
	@Override
	public UserResponse chargePoint(Long userId, int chargeAmount) {
		// TODO Auto-generated method stub
		return null;
	}

}
