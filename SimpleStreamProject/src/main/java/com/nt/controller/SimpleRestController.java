package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Integer> showMsg() {
		
		List<Integer> listNumbers = new ArrayList<>();
		
		listNumbers.add(1);
		listNumbers.add(2);
		listNumbers.add(3);
		listNumbers.add(4);
		listNumbers.add(5);
		
		List<Integer> list = listNumbers.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(list);
		
		return list;
	}
	
	

}
