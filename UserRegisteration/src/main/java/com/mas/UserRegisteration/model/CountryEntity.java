package com.mas.UserRegisteration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "countryentity")
public class CountryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRYID")
	private  Integer countryId;
	@Column(name = "COUNTRYNAME")
	private String countryName;

}
