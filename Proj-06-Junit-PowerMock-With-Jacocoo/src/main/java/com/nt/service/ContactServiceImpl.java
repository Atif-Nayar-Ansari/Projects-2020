package com.nt.service;

import java.util.List;

import com.nt.dao.ContactDAO;
import com.nt.exception.DataNotFoundException;
import com.nt.model.ContactDetails;

public class ContactServiceImpl implements ContactService {

	
	private ContactDAO dao;
	public void setDAO(ContactDAO dao) {
		this.dao=dao;
	}	
	
	//1st method
	public int getAllNumber(String name) {
        
		int number = dao.fetchAllNumber(name);
		if(number==0) {
			System.out.println("No Number is there..");
		}
		return number;
		
	}
	//2nd method
	public List<ContactDetails> getAll() {

	       List<ContactDetails> all = dao.fetchAll();
	       if(all==null) {
				System.out.println("No list is there..");
			}
	       return all;
	}
	
	
	//3rd method
	//here 3 scenario we have to check----
	// 1> DAO returns list of object
	// 2> DAO throws exception
	// 3> DAO returns null value
	public List<ContactDetails> getInActiveRecods(){
		
		List<ContactDetails> inActiveRecordList = null;
		try {
			
			inActiveRecordList = dao.findInActiveRecods();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block is executed..");
		}
		if(inActiveRecordList==null) {
                  //custome exception will be thrown
			throw new DataNotFoundException("Record is not available..Due to Null");
		}
		return inActiveRecordList;
	}
	

}
