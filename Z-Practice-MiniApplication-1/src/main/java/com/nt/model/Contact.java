package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer sno;
	private String name;
	private Long phone;
	private String email;
	private String ActiveSw;
	private Date CreateDate;
	private Date UpdateDate;
}
