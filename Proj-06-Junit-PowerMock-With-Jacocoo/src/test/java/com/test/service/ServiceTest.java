package com.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.nt.dao.ContactDAO;
import com.nt.exception.DataNotFoundException;
import com.nt.model.ContactDetails;
import com.nt.service.ContactServiceImpl;

public class ServiceTest {
	// By using power mock

	@Test
	public void testgetAllNumber01() {

		// create the object of the target class
		ContactServiceImpl service = new ContactServiceImpl();

		// create the dao interface mock object
		ContactDAO daoMock = PowerMockito.mock(ContactDAO.class);

		// now mock it using mock object
		PowerMockito.when(daoMock.fetchAllNumber("swift")).thenReturn(1234);

		// do the setter injection of dao class in service class
		service.setDAO(daoMock);

		// actual checking the proper functionality
		int CommingData = service.getAllNumber("swift");

		assertNotNull(CommingData);
	}
	
	
	
	
	  @Test 
	  public void testgetAllNumber02() {
	  
	  // create the object of the target class 
		  ContactServiceImpl service = new  ContactServiceImpl();
	  
	  // create the dao interface mock object 
		  ContactDAO daoMock =  PowerMockito.mock(ContactDAO.class);
	  
	  // now mock it using mock object
	      PowerMockito.when(daoMock.fetchAllNumber("")).thenReturn(0);
	  
	  // do the setter injection of dao class in service class
	     service.setDAO(daoMock);
	  
	  // actual checking the proper functionality 
	     service.getAllNumber(""); 
	  }
	 

	  @Test
	  public void testGetAll() {
		  
		  // create the target class object.
		  ContactServiceImpl service = new ContactServiceImpl();
		  
		  //create mock for dao interface
		  ContactDAO daoMock = PowerMockito.mock(ContactDAO.class);
		  
		 
		  //before setting behaviour set the list to use in mock
		  List<ContactDetails> list = new ArrayList<ContactDetails>();
		  list.add(new ContactDetails("Alexa", 9438,"Paris" ));
		  list.add(new ContactDetails("Soap", 9438,"Uzbekistan" ));
		  list.add(new ContactDetails("Tavis", 9438,"Dubai" ));
		  
		  //new set mock behaviour
		  PowerMockito.when(daoMock.fetchAll()).thenReturn(list);
		  //insert in dao in service to test service
		  service.setDAO(daoMock);
		  //check agenst the service class method
		  List<ContactDetails> actuallist = service.getAll();
		  assertNotNull(actuallist);
		  
	  }
	  
	  //checking for data comming correctly
	  @Test
	  public void testGetInActiveRecods01() {
		  
		  // create the target class object
		  ContactServiceImpl service = new ContactServiceImpl();
		  
		  // create the mock on object for dao
		   ContactDAO daoMock = PowerMockito.mock(ContactDAO.class);
		   
		   //create dummy objcets
		   List<ContactDetails> list = new ArrayList<ContactDetails>();
		   list.add(new ContactDetails("wikao", 9087, "Hawai"));
		   list.add(new ContactDetails("Xinos", 9087, "Thai"));
		   list.add(new ContactDetails("Jackii", 9087, "China"));
		   list.add(new ContactDetails("Robin", 9087, "Maxico"));
		   
		   //create mock dao with data ready
		   PowerMockito.when(daoMock.findInActiveRecods()).thenReturn(list);
		   
		   //set dao in service
		   service.setDAO(daoMock);
		   
		   //now check for the real class
		   List<ContactDetails> records = service.getInActiveRecods();
		   
		   assertNotNull(records);
	  }
	  
	//checking DAO throws exception
	  @Test(expected = DataNotFoundException.class)
	  public void testGetInActiveRecod02() {
		  
		  // create the target class object
		  ContactServiceImpl service = new ContactServiceImpl();
		  
		  // create the mock on object for dao
		   ContactDAO daoMock = PowerMockito.mock(ContactDAO.class);
		   
		   
		   //create mock dao with data ready
		   PowerMockito.when(daoMock.findInActiveRecods()).thenThrow(new NullPointerException());
		   
		   //do setter injection of dao in service
		   service.setDAO(daoMock);
		   
		   //check the service method
		   List<ContactDetails> recods = service.getInActiveRecods();
		   
	  }
	  
	//checking DAO returns null value
	  @Test(expected = DataNotFoundException.class)
	  public void testGetInActiveRecod03() {
		  
		  // create the target class object
		  ContactServiceImpl service = new ContactServiceImpl();
		  
		  // create the mock on object for dao
		   ContactDAO daoMock = PowerMockito.mock(ContactDAO.class);
		   
		   
		   //create mock dao with data ready
		   PowerMockito.when(daoMock.findInActiveRecods()).thenReturn(null);
		   
		   //do setter injection of dao in service
		   service.setDAO(daoMock);
		   
		   //check the service method
		   service.getInActiveRecods();
	  }
	
}
