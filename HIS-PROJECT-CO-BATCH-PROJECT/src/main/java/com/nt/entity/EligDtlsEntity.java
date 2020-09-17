package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="ELIG_DETAILS")
@Data
public class EligDtlsEntity {
	
	@Id
	@Column(name="ED_TRACE_ID")
	private Integer edTraceId;
	
	@Column(name="BENEFIT_AMT")
	private Integer benefitAmt;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createDt;
	
	@Column(name="DENIAL_REASON")
	private String denialReson;
	
	@Column(name="PLAN_END_DATE")
	private Date planEndDt;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_START_DT")
	private Date planStartDt;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updateDt;

}
