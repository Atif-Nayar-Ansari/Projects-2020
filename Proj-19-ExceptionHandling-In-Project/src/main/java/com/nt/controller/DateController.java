package com.nt.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.excep.MyException;

@Controller
public class DateController {
	
	@RequestMapping(value = "/getnew", method = RequestMethod.GET)
	public String ShowMsg2(Model model) {

		throw new MyException("errrorrrrrs");
		//model.addAttribute("msgnew", new Date());
		//return "datepage";
	}

}
