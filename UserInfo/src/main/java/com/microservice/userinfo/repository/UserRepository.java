package com.microservice.userinfo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.userinfo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByUsername(String username);
	UserModel findUserById(Long id);
}
