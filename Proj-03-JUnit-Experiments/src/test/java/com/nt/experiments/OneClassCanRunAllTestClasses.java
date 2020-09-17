package com.nt.experiments;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class OneClassCanRunAllTestClasses {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(TestCasesClass.class, TestCasesClass02.class);
		
		int runCount = result.getRunCount();
		int failureCount = result.getFailureCount();
		long runTime = result.getRunTime();
		int ignoreCount = result.getIgnoreCount();
		
		List<Failure> failures = result.getFailures();
		
		System.out.println("Run Count: "+runCount);
		System.out.println("Run Failure Count: "+failureCount);
		System.out.println("Run Time: "+runTime);
		System.out.println("Run ignore Count: "+ignoreCount);
		
		
		if(!failures.isEmpty()) {
			
			failures.forEach(failure ->{
				System.out.println(failure.getMessage());
			});
		}
		
		
	}

}
