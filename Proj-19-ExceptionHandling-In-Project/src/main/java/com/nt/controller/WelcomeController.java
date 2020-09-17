package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String ShowMsg(Model model) {

		//String str = null;
		//str.length();
		model.addAttribute("msg", "i there welcome here...");
		return "welco";
	}


}
