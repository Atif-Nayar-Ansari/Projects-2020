package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ContactRepository;
import com.nt.domain.Contact;
import com.nt.entity.ContactEntity;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepository repo;
	
	@Override
	public boolean saveContactDetails(Contact contact) {
		
		ContactEntity entity = new ContactEntity();
		
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		 
		return repo.save(entity).getSno()!=null;//if inserted then it will definately generate sno and return
	}

	@Override
	public Iterable<Contact> retriveAllContactActiveSwOn() {
		
		Iterable<ContactEntity> findAll = repo.findAll();
		
		List<ContactEntity> list = new ArrayList<>();
		
		
		findAll.forEach(ContactEntity->{
			list.add(ContactEntity);
		});
		
		//were you used stream in your project
		List<ContactEntity> filteredList =list.stream()
				                               .filter(entity->entity.getActiveSw().equals("Y"))
				                               .collect(Collectors.toList());
		
		List<Contact> contactList =new ArrayList<>();
		for(ContactEntity ce : filteredList) {
			Contact c = new Contact();
			BeanUtils.copyProperties(ce, c);
			contactList.add(c);
		}
		return contactList;
	}

	@Override
	public Contact findContactById(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateContact(Integer sno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer sno) {
		// TODO Auto-generated method stub
		return false;
	}

}
