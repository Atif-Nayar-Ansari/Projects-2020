package com.nt.domain;



import java.util.Date;

import lombok.Data;

@Data
public class BatchSummary {
	
    private Integer summaryId;
    private String batchName;
    private String createBy;
    private Date createDt;
    private String summaryDtls;
    private String updateBy;
    private Date updateDt;

	


}
