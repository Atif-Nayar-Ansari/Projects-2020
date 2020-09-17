package com.mas.UserRegisteration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mas.UserRegisteration.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	@Query(value = "select  customer_id from cus where customer_id= :userEmail;", nativeQuery = true)
	public Boolean checkEmail(String userEmail);
}
