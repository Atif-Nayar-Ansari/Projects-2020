package com.nt.atif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class CalculatorTest {//test class name must be xxxTest
	
	@Test
	public void testCalculatorPositive() {
		
		Calculator c = new Calculator();
		Integer actual = c.add(10, 10);
		Integer expected = 20;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculatorNegative() {
		
		Calculator c = new Calculator();
		Integer actual = c.add(10, 10);
		Integer expected = 30;
		assertNotEquals(expected, actual);
	}
}
