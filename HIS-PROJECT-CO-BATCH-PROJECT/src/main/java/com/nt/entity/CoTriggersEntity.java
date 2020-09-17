package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CO_TRIGGERS")
@Data
public class CoTriggersEntity {
	@Id
	@Column(name="TRG_ID")
	private Integer trgId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="NOTICE_ID")
	private String noticeId;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDt;
	
	@Column(name="TRG_STATUS")
	private String trgStatus;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updateDt;
	
	@Column(name = "BATCH_NAME")
	private String batchName;

}
