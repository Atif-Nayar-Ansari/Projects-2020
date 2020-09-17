package com.nt.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.BatchRunDtlsEntity;
import com.nt.repository.BatchRunDtlsRepository;

@Component
public abstract class CoDailyGenerateBatch {
	
	@Autowired
	private BatchRunDtlsRepository runDtlsRepo;
	
	public  void preProcess() {
		BatchRunDtlsEntity runDtlsEntity=new BatchRunDtlsEntity();
		
		
		
	}
	public abstract void start();
	public abstract void process();
	public  void postProcess() {}


}
