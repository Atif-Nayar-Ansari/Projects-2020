package com.nt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entities.CityMasterEntity;

public interface CityMasterRepository extends JpaRepository<CityMasterEntity, Integer>{

	  public List<CityMasterEntity> findAllByStateId(Integer sid);
}
