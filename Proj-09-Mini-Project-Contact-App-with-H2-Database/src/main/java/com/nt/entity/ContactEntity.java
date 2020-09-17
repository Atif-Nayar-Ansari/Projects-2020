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
@Table(name = "CONTACT_DETAILS")
public class ContactEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "SNO",length = 7)
	private Integer sno;
	
	@Column(name = "CONTACT_NAME",length = 15)
	private String name;
	
	@Column(name = "CONTACT_EMAIL",length = 15)
	private String email;
	
	@Column(name = "CONTACT_PHONE",length = 15)
	private Long phone;
	
	@Column(name = "ACTIVE_STATUS",length = 10)
	private String ActiveSw;
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE")
	private Date CreatedDate;

	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date UpdateDate;
}
