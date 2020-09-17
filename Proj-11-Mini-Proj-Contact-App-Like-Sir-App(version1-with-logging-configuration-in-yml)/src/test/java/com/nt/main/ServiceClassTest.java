package com.nt.main;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nt.dao.ContactRepository;
import com.nt.entity.ContactEntity;
import com.nt.model.Contact;
import com.nt.service.ContactServiceImpl;

public class ServiceClassTest {
	
	
	//creating the mock obj
	@Mock 
	ContactRepository repo;
   
	@Mock
	ContactEntity entity;
	
	//injecting the mock to the target class
	@InjectMocks
	ContactServiceImpl service;
	
	
	
	@Test
	public void testSaveContact() {
		
		Contact contact = new Contact();
		
		when(repo.save(entity)).thenReturn(null);
		boolean saveContact = service.saveContact(contact);
		assertEquals(null, saveContact);
		
	}
	
	
}
