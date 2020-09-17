package com.mas.UserRegisteration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class CityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITYID")
	private Integer cityId;
	@Column(name = "CITYNAME")
	private String cityName;
	@Column(name = "STATEID")
	private Integer stateId;
}
