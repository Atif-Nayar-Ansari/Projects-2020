package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.nt.constants.AppConstants;
import com.nt.model.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {
	
	//to apply the logger
	private static Logger log = LoggerFactory.getLogger(ContactController.class);
	
	
	
	@Autowired
	private ContactService service;

	//def constructor
	public ContactController() {
		log.debug("instanciated class");
	}

	
	//to show the initial form page
	@RequestMapping("/loadFirstPage")
	public String loadFirstPage(Model model) {
		log.debug("form page loaded");
		Contact contact = new Contact();
		model.addAttribute("cont",contact);
		log.debug("form page load end");
		return AppConstants.CONTACTS;
	}

	//to save the contact (here model data are sending to service->dao->db(formbinding data))
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showResult(@ModelAttribute("cont") Contact contact, Model model) {
		log.debug("save method started");
		boolean saveContact = service.saveContact(contact);
		
		if(saveContact) {
			model.addAttribute(AppConstants.SAVED,AppConstants.SAVED_RESULT);
			log.debug("contact saved");
			//to clear the text box after the clicking the submit button
			model.addAttribute("cont",new Contact());
		}
		else
		{  
			log.error("save failed");
			model.addAttribute(AppConstants.NOT_SAVE,AppConstants.NOT_SAVED);//like this change everything
		}
		log.debug("save method ended");
		return AppConstants.CONTACTS;//like this change every String Literals
	}
	@RequestMapping(value = "/viewallcontact" ,method = RequestMethod.GET)
	public String viewAllContacts(Model model) {
		log.debug("view method started");
		List<Contact> showAllContacts = service.findAllContacts("Y");
		model.addAttribute("showAll", showAllContacts);
		log.debug("save method ended");
		return AppConstants.VIEW_CONTACTS;
	}
	//for to delete the record
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String softDeleteFromDB(@RequestParam("deleteThis")Integer id, RedirectAttributes ra) {
		log.debug("delete method started");
		boolean isDeleted = service.softDeleteById(id);
		
		if(isDeleted) {
			log.info("saved successfully");
			ra.addFlashAttribute("deleted","Record is Deleted successfully..");
			
		}
		else {
			log.info("saved failed");
			ra.addFlashAttribute("deleted","Record is Not Deleted.."); 
		}
		
		log.debug("save method ending");
		return "redirect:/viewallcontact";
		
	}
	//for to edit the selected contact
	@RequestMapping("/edit")
	public String updateTheRecord(HttpServletRequest req,Model model) {
		log.debug("edit method started");
		//to capture the id from the object
		String sid = req.getParameter("sno");
		int sno = Integer.parseInt(sid);
		Contact edit = service.findContactById(sno);
		model.addAttribute("cont",edit);
		log.debug("edit method started");
		return AppConstants.CONTACTS;
	}
}
