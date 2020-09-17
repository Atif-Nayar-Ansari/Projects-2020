package com.nt.service;

import java.util.List;

import com.nt.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	public boolean deleteContact(Integer id);
	public List<Contact> findByActiveSw(String ActiveSw);	
	public Contact updateContact(Integer id);

}
