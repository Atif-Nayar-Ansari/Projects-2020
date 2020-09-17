package com.nt.exception;

public class DataNotFoundException extends RuntimeException {
	public DataNotFoundException(String s) {
		System.out.println(s);
	}
	public DataNotFoundException() {

	}
	
}
