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

@Entity
@Table(name = "anynamedelete")
@Data
public class ContactEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "numbersd")
	private Integer no;
	
	@Column(name = "namea")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pnonenum")
	private Long phone;
	
	@Column(name = "activeornot")
	private String ActiveSw;
	
	@Column(name = "createddate")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdDate;
	
	
	@Column(name = "updateddate")
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedDate;
	

}
