package com.mas.UserRegisteration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mas.UserRegisteration.model.CityEntity;
import com.mas.UserRegisteration.model.StateEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer>{
	public List<CityEntity> findAllByStateId(Integer StateId);
}
