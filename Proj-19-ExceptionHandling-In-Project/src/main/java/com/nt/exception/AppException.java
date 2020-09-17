package com.nt.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nt.excep.MyException;

@Controller
@ControllerAdvice
public class AppException {

	@ExceptionHandler(value = MyException.class)
	public String HandleExc(Model model) {
		model.addAttribute("ex","someerrors");
		return "error";
	}
}
