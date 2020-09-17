package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {
	
	private Integer no;
	private String name;
	private String email;
	private Long phone;
	private String ActiveSw;
	private Date createDate;
	private Date updatedDate;
	
	

}
