package io.hhplus.ECommerce.user.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.hhplus.ECommerce.user.domain.User;
import io.hhplus.ECommerce.user.domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
