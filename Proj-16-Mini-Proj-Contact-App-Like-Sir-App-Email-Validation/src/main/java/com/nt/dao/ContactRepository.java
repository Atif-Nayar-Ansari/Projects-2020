package com.nt.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.ContactEntity;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer>{

	@Modifying //while we change the database with our query then write this 
	@Transactional
	@Query(value = "update ContactEntity set ActiveSw='N' where sno=:id")
	public void softDeleteContact(Integer id);

	@Query(value = "from ContactEntity where ActiveSw=:ActiveSw")
	public List<ContactEntity> findByActiveSw(String ActiveSw);
	
	//for email validation
	//@Query(value = "from ContactEntity where email=:email")
	public ContactEntity findAllByEmail(String email);//here query will be auto generated bcoz Email is written it is match with the Entity class
}
