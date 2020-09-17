package com.nt.experiments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

public class TestCasesClass {
	
	               
                 //---- to show how to unit test which method throws exception-----
	@Test
	@Ignore      // @Ignore will ignore the method while unit testing.
	public void divTest01() {
    	
		ExperimentsForTwo_ExpectedAnd_Timeout obj = new ExperimentsForTwo_ExpectedAnd_Timeout();
		
		Integer actual = obj.div(10, 2);  //no problem
		Integer expected = 5;
		assertEquals(expected, actual);
    } 
	
	
	
	@Test
	@Ignore
	public void divTest02() {
    	
		ExperimentsForTwo_ExpectedAnd_Timeout obj = new ExperimentsForTwo_ExpectedAnd_Timeout();
		
		obj.div(10, 0); //this will throws exception and fails in unit testing to solve this we have to write like below for which method throws exception
    } 
	
	
	@Test(expected = ArithmeticException.class)//if we write like this
	public void divTest03() {
    	
		ExperimentsForTwo_ExpectedAnd_Timeout obj = new ExperimentsForTwo_ExpectedAnd_Timeout();
		
		obj.div(10, 0); //this will solves and pass the test case.
    }
	
	//------------------------------------------------------------------------------------------
                                 //to show which methods throws timeout exception
	
	
	@Test(timeout = 1000)
	public void testTime01() {
		ExperimentsForTwo_ExpectedAnd_Timeout obj = new ExperimentsForTwo_ExpectedAnd_Timeout();
		String name = obj.time();
		//assertNotNull(name);
		assertEquals(null, name);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
