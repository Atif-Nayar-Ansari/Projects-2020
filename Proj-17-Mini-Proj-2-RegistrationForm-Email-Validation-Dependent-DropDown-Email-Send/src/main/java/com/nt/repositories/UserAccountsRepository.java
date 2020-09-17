package com.nt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entities.UserAccountsEntity;

public interface UserAccountsRepository extends JpaRepository<UserAccountsEntity, Integer>{

	public UserAccountsEntity findAllByEmail(String email);
	public UserAccountsEntity findByPazzword(String pazzword);
	
	
}
