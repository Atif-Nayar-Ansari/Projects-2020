package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ContactRepository;
import com.nt.entity.ContactEntity;
import com.nt.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	
	
	   // dao injection
		@Autowired
		private ContactRepository repository;


	//for logging
	private static Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	
	public ContactServiceImpl() {
		log.info("instanciated");
	}
	
	// for saving customer
	@Override
	public boolean saveContact(Contact contact) {

		log.debug("save method started");
		
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		ContactEntity isSave = repository.save(entity);
		
		if (isSave != null) {// if saved successfull then return true if not then return false
			log.debug("saved contact successfully");
			return true;
		} else {
			log.debug("saved contact failed");
			return false;
		}
	}

	// for retrieving one customer details(one row)
	@Override
	public Contact findContactById(Integer id) {
		log.debug("find contact started");
		Contact contact = new Contact();
		Optional<ContactEntity> findById = repository.findById(id);
		if (findById.isPresent()) {
			ContactEntity entity = findById.get();
			BeanUtils.copyProperties(entity, contact);
			log.debug("contact copy from entity to contact");
			return contact;
		}
		return null;// if it does not return any value then simply return null
	}

	
	@Override
	public boolean softDeleteById(Integer id) {
		log.debug("delete method strated");
		repository.softDeleteContact(id);
		log.debug("delete method ending");
		return true;
	}
	
	//to show all the contacts whose active switch is Y
	@Override
	public List<Contact> findAllContacts(String activeSw) {
		
		log.debug("findAllContacts method strated");
		List<ContactEntity> allContact= repository.findByActiveSw(activeSw);
		List<Contact> contactList = new ArrayList<>();
		for(ContactEntity ce: allContact) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(ce, contact);
			contactList.add(contact);
		}
		log.debug("findAllContacts method ending");
		return contactList;
	}   
}
