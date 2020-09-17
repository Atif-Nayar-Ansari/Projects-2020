package com.nt.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {

	private static Logger log = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService service;
	
	public ContactController() {
		log.info("controller class instaciated");
	}
	
	@RequestMapping(value = "/loadFirstPage",method = RequestMethod.GET)
	public String loadFirstPage(Model model) {
		
		Contact contact = new Contact();
		model.addAttribute("cont",contact);
		log.debug("loading first page is done.");
		return "contact";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("cont") Contact contact,Model model) {
	    log.debug("saved method is called from the Controller");
		boolean isSaved = service.saveContact(contact);
		if(isSaved) {
			model.addAttribute("saved","Successfully saved");
		}else {
			model.addAttribute("Notsaved","Not saved");
		}
		return "contact";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteOneRecord(@RequestParam("id") Integer id,RedirectAttributes ra) {
		boolean deleteContact = service.deleteContact(id);
		if(deleteContact) {
			ra.addFlashAttribute("delete","Deleted..");
		}
		else {
			ra.addFlashAttribute("notdelete","Not Deleted..");
		}
		return "redirect:show";
	}
	
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public String showAllContact(Model model) {
		
		List<Contact> findAll = service.findByActiveSw("Y");
		model.addAttribute("list",findAll);
		
		return "contact_details";
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public String updateFunction(@RequestParam("sno") Integer id,Model model) {
		
		Contact updateContact = service.updateContact(id);
		if(updateContact!=null) {
			model.addAttribute("cont",updateContact);
		}
		return "contact";
	}
	
}
