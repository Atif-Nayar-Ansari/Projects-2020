package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ContactRepo;
import com.nt.entity.ContactEntity;
import com.nt.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private static Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactRepo repo;

	@Override
	public boolean saveContact(Contact contact) {
		log.debug("save() started");
		ContactEntity entity = new ContactEntity();
		log.info("copying properties from model to entity");
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw("Y");
		ContactEntity isSave = repo.save(entity);
		if(isSave!=null) {
			log.debug("save() returns true");
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContact(Integer id) {
		repo.softDeleteContact(id);
		return true;
	}

	@Override
	public List<Contact> findByActiveSw(String ActiveSw) {
		List<ContactEntity> findByActiveSw = repo.findByActiveSw(ActiveSw);
		ArrayList<Contact> list = new ArrayList<>();
		for(ContactEntity ce: findByActiveSw) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(ce, contact);
			list.add(contact);
		}
		return list;
	}

	//TO-DO
	@Override
	public Contact updateContact(Integer id) {
		Optional<ContactEntity> findById = repo.findById(id);
		Contact contact = new Contact();
		if(findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
			BeanUtils.copyProperties(contactEntity, contact);
		}
		return contact;
	}

}
