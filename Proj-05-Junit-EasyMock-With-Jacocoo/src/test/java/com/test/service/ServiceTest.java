package com.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nt.dao.ContactDAO;
import com.nt.model.ContactDetails;
import com.nt.service.ContactServiceImpl;

public class ServiceTest { // here code has been improvised

	
	                                
	ContactServiceImpl service = null;
	private List<ContactDetails> all;
	
	
	@Before
	public  void setUp() {
		// common logics are written here to remove the boiller plate code.
		// injecting mock dao into the service bean
		service = new ContactServiceImpl();
		// creating mock object for Dao interface
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		service.setDAO(daoMock);
		
		// set expected behaviour
		EasyMock.expect(daoMock.fetchAllNumber("john")).andReturn(1234);
		EasyMock.expect(daoMock.fetchAllNumber("smith")).andReturn(4321);
		// set expected behaviour
		EasyMock.expect(daoMock.fetchAllNumber("wasima")).andReturn(0);


		
	     // save the behaviour
		 EasyMock.replay(daoMock);

	}

	@Test    // it is for 1st method
	public void testGetAllNumberPositive01() {

		// calling target class method to test
		int output = service.getAllNumber("john");

		// verify result
		assertNotNull(output);
	}

	@Test    // it is for 1st method
	public void testGetAllNumberNegative02() {

		// calling target class method to test
		int output = service.getAllNumber("wasima");

		// verify result
		assertNotNull(output);
	}

	@Test
	public void testGetAllPositive() {

		// 2nd method test case
		List<ContactDetails> contactList = new ArrayList<ContactDetails>();
		contactList.add(new ContactDetails("john", 101, "Odisha"));
		contactList.add(new ContactDetails("linda", 102, "Paris"));
		contactList.add(new ContactDetails("Same", 103, "London"));

		
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		service.setDAO(daoMock);

		// set expected behaviour
		EasyMock.expect(daoMock.fetchAll()).andReturn(contactList);
		EasyMock.replay(daoMock);

		service.setDAO(daoMock);

		List<ContactDetails> actualContacts = service.getAll();

		assertNotNull(actualContacts);

	}
	@Test
	public void testGetAllNegative() {

		// 2nd method test case
		List<ContactDetails> contactList = new ArrayList<ContactDetails>();
		contactList.add(new ContactDetails("john", 101, "Odisha"));
		contactList.add(new ContactDetails("linda", 102, "Paris"));
		contactList.add(new ContactDetails("Same", 103, "London"));

		
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		service.setDAO(daoMock);

		// set expected behaviour
		EasyMock.expect(daoMock.fetchAll()).andReturn(null);
		EasyMock.replay(daoMock);

		service.setDAO(daoMock);

		all = service.getAll();
		
		assertEquals(null, all);


	}
	
	@After
	public void tearDown() {
		service = null;
	}
}
