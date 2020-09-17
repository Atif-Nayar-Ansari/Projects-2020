package com.nt.excep;

import org.springframework.stereotype.Component;

@Component
public class MyException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String str) {
	  super(str);
	}
	public MyException() {
		// TODO Auto-generated constructor stub
	}

}
