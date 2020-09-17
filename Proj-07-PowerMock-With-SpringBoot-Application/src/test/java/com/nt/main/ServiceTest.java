package com.nt.main;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;

import com.nt.dao.ContactDAO;
import com.nt.service.ContactServiceImpl;

@SpringBootTest
public class ServiceTest {
	
	@Mock
	private ContactDAO dao;
	
	@InjectMocks
	private ContactServiceImpl service;
	
	//for checking correct result is comming or not
	@Test
	public void testGetContactNumByName01() { 

		when(dao.fetchContactNumByName("Tailor")).thenReturn((long) 123242);
		Long result = service.getContactNumByName("Tailor");
		assertNotNull(result);
	}
	
	//when we don't know how many argument is to be passed then use this:-"ArgumentMatchers.anyString())"
	@Test
	public void testGetContactNumByName02() { 

		when(dao.fetchContactNumByName(ArgumentMatchers.anyString())).thenReturn((long) 123242);
		Long result = service.getContactNumByName("Tailor");
		assertNotNull(result);
	}
	
	
	//when we don't know how many argument is to be passed then use this:-"ArgumentMatchers.any())"
		@Test
		public void testGetContactNumByName03() { 

			when(dao.fetchContactNumByName(ArgumentMatchers.any())).thenReturn((long) 12);
			Long result = service.getContactNumByName("Tailor");
			assertNotNull(result);
		}
		
	//when we want to call the real implementation method of the dao(Dao real implementation)
		@Test      //NOT WORKING
		@Ignore
		public void testGetContactNumByName04() { 
			
			when(dao.fetchContactNumByName("Rita")).thenCallRealMethod();
			Long result = service.getContactNumByName("Rita");
			assertNull(result);// dao implementation class returns null.
		}
		
		//how to test the private method 
		 @Test
		 @Ignore
		public void  testGetNameByNumber()throws Exception {
			ContactServiceImpl service  =  new ContactServiceImpl();
			Whitebox.invokeMethod(ContactServiceImpl.class, "getNameByNumber");
			when(dao.fetchNameByNumber(9090)).thenReturn("atif");
			Long name = service.getContactNumByName("atif");
			assertNotNull(name);
			
			
		}
		
		
}
