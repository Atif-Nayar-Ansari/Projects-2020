package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.ContactEntity;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

}
