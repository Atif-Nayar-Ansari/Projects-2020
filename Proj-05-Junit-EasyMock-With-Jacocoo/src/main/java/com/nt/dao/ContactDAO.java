package com.nt.dao;

import java.util.List;

import com.nt.model.ContactDetails;

public interface ContactDAO {

	public int fetchAllNumber(String name); 
	
	public List<ContactDetails> fetchAll();
}
