package com.nt.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccounts {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String pazzword;
	
	private String mobile;
	
	private Date dob;
	
	private Character gender;
	
	private Integer countryId;
	
	private Integer stateId;
	
	private Integer cityId;	
	
	private Character activeStatus;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	


}
