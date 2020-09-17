package com.nt.domain;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class CoTriggers {
	
	private Integer trgId;
	private Integer caseNum;
	private String noticeId;
	private Date createDt;
	private String trgStatus;
	private Date updateDt;
	private String batchName;



}
