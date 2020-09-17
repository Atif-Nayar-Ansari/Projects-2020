package com.nt.service;

import com.nt.domain.Contact;

public interface ContactService {
	
	public boolean saveContactDetails(Contact contact);
	
	public Iterable<Contact> retriveAllContactActiveSwOn();
	
	public Contact findContactById(Integer cId);
	
	public boolean updateContact(Integer sno);
	
	public boolean deleteContact(Integer sno);
	
}
