package com.nt.domain;

import java.util.Date;

import lombok.Data;


@Data
public class BatchRunDtls {
     
	private Integer runId;
	private String batchName;
    private String createBy;
    private Date createDt;//
	private Date endDt;
    private String runStatus;
	private Date startDt;
	private Date updateDt;//
	private String updateBy;


}
