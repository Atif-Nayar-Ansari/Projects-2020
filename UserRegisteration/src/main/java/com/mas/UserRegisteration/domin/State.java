package com.mas.UserRegisteration.domin;

import javax.persistence.Column;

import lombok.Data;
@Data
public class State {
	private Integer stateId;
	private Integer countryId;
	private String stateName;
}
