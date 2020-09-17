package com.mas.UserRegisteration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mas.UserRegisteration.model.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
