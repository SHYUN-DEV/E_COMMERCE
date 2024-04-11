package io.hhplus.ECommerce.user.domain;

import java.util.Optional;

public interface UserRepository {

	public User findById(Long userId); 

}
