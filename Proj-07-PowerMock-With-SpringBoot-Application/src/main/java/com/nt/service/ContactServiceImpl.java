package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO dao;
	
	@Override
	public Long getContactNumByName(String name) {
 
		long num = dao.fetchContactNumByName(name);
		
		return num;
	}
	
	
	//this is a private method and we have to mock it
	private String getNameByNumber(Integer num) {
	    String name = dao.fetchNameByNumber(num); 
		return name;
	}

}
