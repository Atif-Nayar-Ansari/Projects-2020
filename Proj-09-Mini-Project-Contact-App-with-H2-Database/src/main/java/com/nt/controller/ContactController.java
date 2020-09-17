package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.domain.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {
	
	
	@Autowired
	private ContactService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "home_page";
	}
	
	@RequestMapping("/save")
	public String saveContact(@ModelAttribute Contact contact,Model model) {
		
		String msg = null;
		boolean saveContactDetails = service.saveContactDetails(contact);
		if(saveContactDetails==true) {
			msg="Data is successfully saved..";
		}
		else
		{
			msg="Data is Not saved..";
		}
		model.addAttribute("allContacts",msg);
		return "list_page";
	}

}
