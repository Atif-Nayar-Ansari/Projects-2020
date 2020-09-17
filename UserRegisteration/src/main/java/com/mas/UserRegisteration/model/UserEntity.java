package com.mas.UserRegisteration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "USERDEATILSSS")
public class UserEntity {
	@Id
	@GenericGenerator(strategy ="com.mas.UserRegisteration.utils.CustomGenrateUtil", name = "cid_gen")
	@GeneratedValue(generator = "cid_gen")
	@Column(name = "USERID")
	private String userId;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "LASTNAME")
	private String userLastName;
	@Column(name = "EMAIL")
	private String userEmail;
	@Column(name = "PAZZWORD")
	private String userPazzword;
	@Column(name = "MOBILE")
	private String userPhonenumber;
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Column(name = "GENDER")
	private Character gender;
	@Column(name = "CITYID")
	private Integer cityId;
	@Column(name = "STATEID")
	private Integer stateId;
	@Column(name = "COUNTRYID")
	private Integer countryId;
	@Column(name = "ACTIVEFLAG")
	private Character activeFlag;
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "UPDATEDATE")
	private Date updatedDate;
	@Column(name = "CREATEDBY")
	private String createdBy;
	@Column(name = "UPDATEBY")
	private String updatedBy;

}
