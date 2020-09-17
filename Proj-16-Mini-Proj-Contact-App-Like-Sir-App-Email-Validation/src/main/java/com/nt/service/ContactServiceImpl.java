package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ContactRepository;
import com.nt.entity.ContactEntity;
import com.nt.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	
	public ContactServiceImpl() {
	}
	// dao injection
	@Autowired
	private ContactRepository repository;

	// for saving customer
	@Override
	public boolean saveContact(Contact contact) {

		
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		ContactEntity isSave = repository.save(entity);
		
		if (isSave != null) {// if saved successfull then return true if not then return false
			return true;
		} else {
			return false;
		}
	}

	// for retrieving one customer details(one row)
	@Override
	public Contact findContactById(Integer id) {
		Contact contact = new Contact();
		Optional<ContactEntity> findById = repository.findById(id);
		if (findById.isPresent()) {
			ContactEntity entity = findById.get();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		return null;// if it does not return any value then simply return null
	}

	
	@Override
	public boolean softDeleteById(Integer id) {
		repository.softDeleteContact(id);
		return true;
	}
	
	//to show all the contacts whose active switch is Y
	@Override
	public List<Contact> findAllContacts(String ActiveSw) {
		
		List<ContactEntity> allContact= repository.findByActiveSw(ActiveSw);
		List<Contact> contactList = new ArrayList<>();
		for(ContactEntity ce: allContact) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(ce, contact);
			contactList.add(contact);
		}
		return contactList;
	}   
	//for email validation
	@Override
	public String validateEmail(String email) {
		ContactEntity entity = repository.findAllByEmail(email);
		if(entity==null) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}
}
