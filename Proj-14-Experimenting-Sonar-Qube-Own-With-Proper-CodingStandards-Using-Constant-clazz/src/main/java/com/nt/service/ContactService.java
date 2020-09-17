package com.nt.service;

import java.util.List;

import com.nt.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	public Contact findContactById(Integer id);
	public boolean softDeleteById(Integer id);
	public List<Contact> findAllContacts(String activeSw);
	
}
