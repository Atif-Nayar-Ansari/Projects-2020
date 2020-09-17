package com.test.service;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;

import com.nt.dao.ContactDAO;
import com.nt.model.ContactDetails;
import com.nt.service.ContactServiceImpl;

public class ServiceTest {

	@Test
	@Ignore
	public void testGetAllNumberPositive01() {
		
		//it is for 1st method
		// creating mock object for Dao interface
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		
		//set expected behaviour
		EasyMock.expect(daoMock.fetchAllNumber("john")).andReturn(1234);
		
		EasyMock.expect(daoMock.fetchAllNumber("smith")).andReturn(4321);
		
		//save the behaviour
		EasyMock.replay(daoMock);
		
		
		//injecting mock dao into the service bean
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDAO(daoMock);
		
		//calling target class method to test
		int output = service.getAllNumber("john");
		
		//verify result
		assertNotNull(output);
	}
	
	@Test
	@Ignore
	public void testGetAllNumberNegative02() {
		//it is for 1st method		
		// creating mock object for Dao interface
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		
		//set expected behaviour
		EasyMock.expect(daoMock.fetchAllNumber("wasima")).andReturn(0);
		
		//save the behaviour
		EasyMock.replay(daoMock);
		
		
		//injecting mock dao into the service bean
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDAO(daoMock);
		
		//calling target class method to test
		int output = service.getAllNumber("wasima");
		
		//verify result
		assertNotNull(output);
	}
	
	@Test
	public void testGetAll() {
		
		// 2nd method test case
		List<ContactDetails> contactList = new ArrayList<ContactDetails>();
		contactList.add(new ContactDetails("john",101,"Odisha"));
		contactList.add(new ContactDetails("linda",102,"Paris"));
		contactList.add(new ContactDetails("Same",103,"London"));
		
		
		//creating mock object for Dao interface
		ContactDAO daoMock = EasyMock.createMock(ContactDAO.class);
		
		//set expected behaviour
		EasyMock.expect(daoMock.fetchAll()).andReturn(contactList);
		EasyMock.replay(daoMock);
		
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDAO(daoMock);
		
		List<ContactDetails> actualContacts = service.getAll();
		
		assertNotNull(actualContacts);
		
		
	}
	//to test the private method we have to use the reflection api
	@Test
	public void testDoWork() throws Exception {
		
		//load the class
		Class<?> clz = Class.forName("com.nt.service.ContactServiceImpl");
		//create the object
		Object obj = clz.newInstance();
		//load the methods
		Method m = clz.getDeclaredMethod("doWork", null);
		m.setAccessible(true);
		m.invoke(obj, null);
		
		
	}
}
