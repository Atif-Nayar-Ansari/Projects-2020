package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {
	
	
	
	@Autowired
	private ContactService service;

	
	//to show the initial form page
	@RequestMapping("/loadFirstPage")
	public String LoadFirstPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("cont",contact);
		return "contact";
	}

	//to save the contact (here model data are sending to service->dao->db(formbinding data))
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showResult(@ModelAttribute("cont") Contact contact, Model model) {
		boolean saveContact = service.saveContact(contact);
		
		if(saveContact) {
			model.addAttribute("saveResult","Saved Successfully...");
		}
		else
		{  
			model.addAttribute("notSaveResult","Not Saved...");
		}
		return "contact";
	}
	@RequestMapping(value = "/viewallcontact" ,method = RequestMethod.GET)
	public String viewAllContacts(Model model) {
		List<Contact> showAllContacts = service.findAllContacts("Y");
		model.addAttribute("showAll", showAllContacts);
		return "view_contacts";
	}
	//for to delete the record
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String softDeleteFromDB(@RequestParam("deleteThis")Integer id, RedirectAttributes ra) {
	//public String softDeleteFromDB(HttpServletRequest req, RedirectAttributes ra) {
		//String sid = req.getParameter("deleteThis");
		//int id = Integer.parseInt(sid);
		String deleteMsg = null;
		boolean isDeleted = service.softDeleteById(id);
		
		if(isDeleted) {
			deleteMsg = "Record is Successfully Deleted..";
		}
		else {
			deleteMsg = "Record is Not Deleted..";
		}
		//show the delete message
		ra.addFlashAttribute("deleted",deleteMsg); //here we have to use the addFlashAtribute to send the request to the other 
												   //method to use that attribute
		
		return "redirect:/viewallcontact";//write the url directly to redirect the other method
		
	}
	//for to edit the selected contact
	@RequestMapping("/edit")
	public String updateTheRecord(HttpServletRequest req,Model model) {
		//to capture the id from the object
		String sid = req.getParameter("sno");
		int sno = Integer.parseInt(sid);
		Contact edit = service.findContactById(sno);
		model.addAttribute("cont",edit);
		return "contact";
	}
	//for validating the email
	@RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
	public @ResponseBody String validateEmail(@RequestParam("email") String email) {
		String str = service.validateEmail(email);
		return str;
	}
	
}
