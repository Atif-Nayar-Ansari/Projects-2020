package com.nt.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "About the CONTACT CLASS")
public class Contact {

	@ApiModelProperty(notes = "SNO Variable")
	private Integer sno;
	@ApiModelProperty(notes = "Name Variable")
	private String name;
	private String email;
	private Long phone;
	private String ActiveSw;
	private Date CreatedDate;
	private Date UpdateDate;
}