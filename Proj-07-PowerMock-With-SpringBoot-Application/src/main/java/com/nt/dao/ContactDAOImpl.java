package com.nt.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Override
	public Long fetchContactNumByName(String name) {

		System.out.println("DAO implementation class is executed...");
		return null;
	}
	
	
	@Override
	public String fetchNameByNumber(Integer num) {
		System.out.println("DAO returning the number...");
		return null;
	}

}
