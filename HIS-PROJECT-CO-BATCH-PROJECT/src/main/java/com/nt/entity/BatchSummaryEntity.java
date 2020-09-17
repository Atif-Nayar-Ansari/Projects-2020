package com.nt.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="BATCH_SUMMARY")
public class BatchSummaryEntity {
    @Id
    @GeneratedValue
    @Column(name="SUMMARY_ID")
	private Integer summaryId;
	
    @Column(name="BATCH_NAME")
    private String batchName;
	
    @Column(name="CREATE_BY")
	private String createBy;
	
    @Column(name="CREATE_DT")
    @CreationTimestamp
	private Date createDt;
	
    @Column(name="SUMMARY_DTLS")
	private String summaryDtls;
	
    @Column(name="UPDATE_BY")
	private String updateBy;
	

    @Column(name="UPDATE_DT")
    @UpdateTimestamp
    private Date updateDt;
	
}
