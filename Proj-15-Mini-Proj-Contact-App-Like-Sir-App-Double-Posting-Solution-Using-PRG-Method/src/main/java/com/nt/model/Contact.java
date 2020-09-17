package com.nt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	private Integer sno;
	private String name;
	private String email;
	private Long phone;
	private String ActiveSw;
	private Date CreatedDate;
	private Date UpdateDate;
}