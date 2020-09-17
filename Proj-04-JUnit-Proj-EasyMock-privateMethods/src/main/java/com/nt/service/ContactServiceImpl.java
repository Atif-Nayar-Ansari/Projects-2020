package com.nt.service;

import java.util.List;

import com.nt.dao.ContactDAO;
import com.nt.model.ContactDetails;

public class ContactServiceImpl implements ContactService {

	
	/*private ContactDAO dao;
	public ContactServiceImpl(ContactDAO dao) {
		this.dao = dao;
	}*/
	private ContactDAO dao;
	public void setDAO(ContactDAO dao) {
		this.dao=dao;
	}	
	
	//1st method
	@Override
	public int getAllNumber(String name) {
        
		int number = dao.fetchAllNumber(name);
		if(number==0) {
			System.out.println("No Number is there..");
		}
		return number;
		
	}
	//2nd method
	@Override
	public List<ContactDetails> getAll() {

	       List<ContactDetails> all = dao.fetchAll();
	       if(all==null) {
				System.out.println("No list is there..");
			}
	       return all;
	}
	
	// interviewer: how do you unit test the private method.
	private void doWork() {
		System.out.println("Hi there this is from the private method.");
	}

}
