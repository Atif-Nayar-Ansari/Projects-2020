package com.nt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccountsEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "EMAIL",unique = true)
	private String email;
	
	@Column(name = "PAZZWORD")
	private String pazzword;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "GENDER")
	private Character gender;
	
	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	
	@Column(name = "CITY_ID")
	private Integer cityId;
	

	@Column(name = "ACTIVE_STATUS")
	private Character activeStatus;
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE",insertable = false)
	private Date updatedDate;
	

}
