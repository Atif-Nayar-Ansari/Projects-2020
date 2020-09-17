package com.nt.domain;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class EligDtls {
	
    private Integer edTraceId;
	private Integer benefitAmt;
	private Integer caseNum;
	private Date createDate;
	private String denialReson;
	private Date planEndDt;
	private String planName;
	private Date planStartDt;
	private String planStatus;
	private String updateDt;
	
}
