package com.nt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entities.StateMasterEntity;

public interface StateMasterRepository  extends JpaRepository<StateMasterEntity, Integer>{

	public List<StateMasterEntity> findAllByCountryId(Integer cid);
}
