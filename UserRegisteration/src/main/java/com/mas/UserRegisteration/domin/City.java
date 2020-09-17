package com.mas.UserRegisteration.domin;

import javax.persistence.Column;

import lombok.Data;

@Data

public class City {

	@Column(name = "CITYID")
	private Integer cityId;
	@Column(name = "CITYNAME")
	private String cityName;
	@Column(name = "STATEID")
	private Integer stateId;
}
