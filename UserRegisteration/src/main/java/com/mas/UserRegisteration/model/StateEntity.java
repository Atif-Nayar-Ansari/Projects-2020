package com.mas.UserRegisteration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "state")
public class StateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATEID")
	private Integer stateId;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "COUNTRYID")
	 */
	@Column(name ="COUNTRYID")
	private Integer countryId;
	@Column(name = "STATENAME")
	private String stateName;
}
