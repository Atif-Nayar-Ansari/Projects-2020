package com.nt.service;

import java.util.List;

import com.nt.model.ContactDetails;

public interface ContactService {
	
	public int getAllNumber(String name);
	public List<ContactDetails> getAll();

}
