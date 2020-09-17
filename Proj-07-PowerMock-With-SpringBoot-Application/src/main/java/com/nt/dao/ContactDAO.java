package com.nt.dao;

public interface ContactDAO {
	
	public Long fetchContactNumByName(String name);

	public String fetchNameByNumber(Integer num);
}
