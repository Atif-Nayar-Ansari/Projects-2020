package com.nt.experiments;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCasesClass02 {
	
	@Test
	public void divTest04() {
    	
		ExperimentsForTwo_ExpectedAnd_Timeout obj = new ExperimentsForTwo_ExpectedAnd_Timeout();
		
		Integer actual = obj.div(10, 5);  //no problem
		Integer expected = 2;
		assertEquals(expected, actual);
    } 

}
