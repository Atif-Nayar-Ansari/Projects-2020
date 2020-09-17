package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="BATCH_RUN_DTLS")
@Data
public class BatchRunDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name="RUN_ID")
	private Integer runId;
	
	@Column(name="BATCH_NAME")
	private String batchName;
	
	@Column(name="CREATE_BY")
	private String createBy;
	
	@Column(name="CREATE_DT",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDt;
	
	@Column(name="END_DT")
	private Date endDt;
	
	@Column(name="RUN_STATUS")
	private String runStatus;
	
	@Column(name="START_DT")
	private Date startDt;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updateDt;
	
	@Column(name="UPDATE_BY")
	private String updateBy;

	
	
	

}
