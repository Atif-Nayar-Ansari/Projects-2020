package com.nt.entity;

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
@Table(name = "CONTACT_APP_LIKE_SIR")
public class ContactEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_SNO", length = 5)	
	private Integer sno;
	
	@Column(name = "CONTACT_NAME", length = 20)
	private String name;
	
	@Column(name = "CONTACT_EMAIL", length = 40)
	private String email;
	
	@Column(name = "CONTACT_PHONE", length = 20)
	private Long phone;
	
	@Column(name = "CONTACT_ACTIVE_SWITCH", length = 7)
	private String activeSw;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CONTACT_CREATION_DATE", length = 15,updatable = false)
	private Date createdDate;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CONTACT_UPDATE_DATe", length = 15,insertable = false)
	private Date updateDate;
}
