package com.nt.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExperimentTest {

	//it will run before the class execution 
	private static Experiments exp = null;
	@BeforeClass
	public static void setup() {
		
		exp = new Experiments();
	}
	
	
	
	
	@Test
	public  void TestExperiment() {
	
		Integer actual =exp.add(10, 20);
		Integer expected = 30;
		assertEquals(expected, actual);
	}
	
	
	
	//it will destrory the object and it will run at the end 
	@AfterClass
	public static void tearDown() {
		exp = null;
	}
	
}
