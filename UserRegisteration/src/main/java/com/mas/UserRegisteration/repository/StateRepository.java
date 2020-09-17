package com.mas.UserRegisteration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mas.UserRegisteration.model.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
	//@Query(value = "select * from state where countryId= :countryId",nativeQuery = true)
	public List<StateEntity> findAllByCountryId(Integer countryId);

}
