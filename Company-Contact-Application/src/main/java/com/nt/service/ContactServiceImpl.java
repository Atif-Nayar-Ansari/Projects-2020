package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ContactEntity;
import com.nt.model.Contact;
import com.nt.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository repo;
	
	
	@Override
	public boolean saveContactDetails(Contact contact) {
		
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		ContactEntity save = repo.save(entity); 
		if(save!=null) {
			return true;
		}
		else{
			return false;
		}
	}

}
