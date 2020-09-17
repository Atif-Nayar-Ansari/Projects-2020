package com.nt.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer sno;
	private String name;
	private String email;
	private Long phone;
	private String ActiveSw;
	private Date CreatedDate;
	private Date UpdateDate;
}