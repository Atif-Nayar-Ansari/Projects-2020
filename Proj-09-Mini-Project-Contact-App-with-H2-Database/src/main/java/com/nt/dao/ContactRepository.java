package com.nt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.ContactEntity;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity,Integer>{

}
