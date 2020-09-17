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
@Table(name = "Contact_App_Pracice")
public class ContactEntity {

	@Id
	@GeneratedValue
	@Column(name = "Sno",length = 5)
	private Integer sno;
	
	@Column(name = "Name",length = 10)
	private String name;
	
	@Column(name = "Phone",length = 15)
	private Long phone;
	
	@Column(name = "Email",length = 20)
	private String email;
	
	@Column(name = "Status",length = 5)
	private String ActiveSw;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CreationDT",length = 20,updatable = false)
	private Date CreateDate;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UpdateionDT",insertable = false)
	private Date UpdateDate;
}
