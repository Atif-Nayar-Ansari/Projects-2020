package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService service;
	
	@RequestMapping("/get")
	public String loadPage() {
		return "contact_page";
	}
	
	@RequestMapping("/save")
	public String saveDetails(@ModelAttribute Contact contact, Model model) {
		String msg = null;
		boolean saveContactDetails = service.saveContactDetails(contact);
		if(saveContactDetails==true) {
			msg = "Saved Successfully..";
		}else {
			msg = "Not Saved";
		}
		model.addAttribute("data",msg);
		return "list_page";
	}
}
