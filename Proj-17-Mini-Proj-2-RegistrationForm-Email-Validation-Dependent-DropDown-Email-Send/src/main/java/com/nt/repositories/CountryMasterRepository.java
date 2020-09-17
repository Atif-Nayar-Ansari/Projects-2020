package com.nt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entities.CountryMasterEntity;

public interface CountryMasterRepository extends JpaRepository<CountryMasterEntity, Integer>{

	
	//public List<CountryMasterEntity> findAllCountry();
}
